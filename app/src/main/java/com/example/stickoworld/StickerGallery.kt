package com.example.stickoworld


import android.app.Activity
import android.app.usage.ExternalStorageStats
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.JobIntentService.enqueueWork
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.lang.Exception
import java.security.Permission
import java.util.jar.Manifest

@Suppress("DEPRECATION")
class StickerGallery : Activity() {

    lateinit var cartoon:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stickergallery)

        cartoon=findViewById(R.id.cartoon)
        cartoon.setOnClickListener {
            if (VERSION.SDK_INT>=Build.VERSION_CODES.M)
            {
                if (checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED)
                        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                            ),100)
            }
            else{

            }
        }

        fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

            if (requestCode==100)
            {
                if (grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {

                }
                else
                {

                }
            }

        }

    }
    public fun SaveImageToGallery()
    {
        val externalStorageState=Environment.getExternalStorageState()
        if (externalStorageState.equals(Environment.MEDIA_MOUNTED))
        {
            val storageDirectory=Environment.getExternalStorageState().toString()
            val file=File(storageDirectory,"test_img.png")
            try {
                val stream:OutputStream=FileOutputStream(file)
                var drawable=ContextCompat.getDrawable(applicationContext,R.drawable.bollywood1)
                var bitmap=(drawable as BitmapDrawable).bitmap
                bitmap.compress(Bitmap.CompressFormat.PNG,100,stream)
                stream.flush()
                stream.close()
                Toast.makeText(this,"Sucessfully Stickers saved to your gallery",Toast.LENGTH_SHORT)
            }
            catch(e:Exception)
            {
                   Toast.makeText(this,"Unable to save stickers to your gallery",Toast.LENGTH_SHORT)
            }
        }
    }

}


