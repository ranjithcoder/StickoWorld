package com.example.stickoworld

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Aboutus : AppCompatActivity() {
    lateinit var TextView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_layout)

        TextView=findViewById<TextView>(R.id.adi)
        TextView.setOnClickListener {
            val url="https://www.instagram.com/pandey_adi26/"
            val io= Intent(Intent.ACTION_VIEW)
            io.data= Uri.parse(url)
            startActivity(io)
        }

        TextView=findViewById<TextView>(R.id.bandary)
        TextView.setOnClickListener {
            val url="https://instagram.com/sohan24.py?igshid=1kqtbwz0r2zga"
            val ia= Intent(Intent.ACTION_VIEW)
            ia.data= Uri.parse(url)
            startActivity(ia)
        }

        TextView=findViewById<TextView>(R.id.ranjith)
        TextView.setOnClickListener {
            val url="https://instagram.com/ranjithjupaka_1?igshid=1gq84kjcnp08n"
            val ib= Intent(Intent.ACTION_VIEW)
            ib.data= Uri.parse(url)
            startActivity(ib)
        }
    }
}