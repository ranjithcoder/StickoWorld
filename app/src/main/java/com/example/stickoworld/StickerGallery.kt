package com.example.stickoworld


import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.JobIntentService.enqueueWork
import com.google.firebase.storage.FirebaseStorage

@Suppress("DEPRECATION")
class StickerGallery : Activity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stickergallery)

        textView= findViewById<TextView>(R.id.cartoon)
    textView.setOnClickListener(View.OnClickListener {
            AppIndexingUpdateService().enqueueWork(
                this@StickerGallery
            )
        });
    }




}


