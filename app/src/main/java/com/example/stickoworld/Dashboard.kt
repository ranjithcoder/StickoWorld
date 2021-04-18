package com.example.stickoworld


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlin.system.exitProcess

class Dashboard : AppCompatActivity() {

    lateinit var ImageView:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)



        ImageView = findViewById<ImageView>(R.id.profile)
        ImageView.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)

        }


        ImageView= findViewById<ImageView>(R.id.exit)
        ImageView.setOnClickListener{
            moveTaskToBack(true)
            android.os.Process.killProcess(android.os.Process.myPid())
            exitProcess(1)
        }

        ImageView= findViewById<ImageView>(R.id.setting)
        ImageView.setOnClickListener {
            val intent=Intent(this,Settings::class.java)
            startActivity(intent)
        }


        val stickers=findViewById<ImageView>(R.id.funpalce)
        stickers.setOnClickListener {
            Toast.makeText(this, "You will be redirected to the fun place", Toast.LENGTH_SHORT).show()
            val intent=Intent(this,StickerGallery::class.java)
            startActivity(intent)
        }


    }

    override fun onBackPressed() {
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Are you sure!!")
        builder.setMessage("Do you want to exit?")
        builder.setPositiveButton("Yes"){dialogInterface, which ->
            finish()
        }
        builder.setNegativeButton("No"){dialogInterface, which ->

        }
        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

}