package com.example.stickoworld


import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.JobIntentService.enqueueWork
import com.google.firebase.storage.FirebaseStorage

@Suppress("DEPRECATION")
class StickerGallery : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stickergallery)

        val mBtnAddSticker = findViewById<Button>(R.id.cartoon)
        mBtnAddSticker.setOnClickListener(View.OnClickListener {
            AppIndexingUpdateService().enqueueWork(
                this@StickerGallery
            )
        });
    }




}


