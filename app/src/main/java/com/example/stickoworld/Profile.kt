package com.example.stickoworld

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.profile_activity.*

class Profile : AppCompatActivity() {

    companion object {
        const val REQ_FROM_GALLERY=1001
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)

        initUI()
    }

    private fun initUI() {

        profile_btn.setOnClickListener{
            PickImageFromGallery()
        }
    }

    private fun PickImageFromGallery() {
        ImagePicker.with(this).galleryOnly().crop().start(REQ_FROM_GALLERY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode==Activity.RESULT_OK)
        {
            val imgProfile=findViewById<ImageView>(R.id.profile_image)
            imgProfile.setImageURI(data!!.data)
        }
    }

}