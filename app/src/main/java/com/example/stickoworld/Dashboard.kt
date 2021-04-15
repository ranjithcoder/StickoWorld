package com.example.stickoworld


import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.bottom_menu,menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.about->{
                val ab = AboutDialogue()
                ab.show(supportFragmentManager, "SHOWN")
                return true
            }
            else->{

            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val builder=AlertDialog.Builder(this)
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

