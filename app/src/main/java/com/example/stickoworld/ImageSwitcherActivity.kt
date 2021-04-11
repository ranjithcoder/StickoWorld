package com.example.stickoworld

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


@Suppress("DEPRECATION")
class ImageSwitcherActivity : AppCompatActivity() {
    private var animationCounter:Int=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val imageSwitcher=findViewById<ImageSwitcher>(R.id.imageSwitcher)
        imageSwitcher?.setFactory {
            val imageView= ImageView(applicationContext)
            imageView.scaleType= ImageView.ScaleType.FIT_CENTER
            imageView.setPadding(8,8,8,8)
            imageView
        }

        val imageIn= AnimationUtils.loadAnimation(
            this,android.R.anim.slide_in_left)
        imageSwitcher?.inAnimation=imageIn
        val imageOut= AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right)
        imageSwitcher?.outAnimation=imageOut

        Handler().post {
            val timer= object : CountDownTimer(12000,8000)
            {
                override fun onTick(millisUntilFinished: Long)
                {
                    when (animationCounter) {
                        1 -> imageSwitcher?.setImageResource(R.drawable.image2)
                        2 -> imageSwitcher?.setImageResource(R.drawable.image4)
                        3 -> imageSwitcher?.setImageResource(R.drawable.image5)
                        4 -> imageSwitcher?.setImageResource(R.drawable.image7)
                    }
                    animationCounter++
                }

                override fun onFinish() {
                    val intent = Intent(applicationContext, Dashboard::class.java)
                    startActivity(intent)
                }


            }

        }

    }
}