package com.example.stickoworld

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.airbnb.lottie.LottieAnimationView
import com.sangcomz.fishbun.FishBun
import com.sangcomz.fishbun.adapter.image.ImageAdapter
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter
import java.util.*

class NewStickerPackActivity: AppCompatActivity() {

    var imageAdapter:ImageAdapter? = null
    var nameEdit: EditText? = null
    var authorEdit: EditText? = null
    var empty: LottieAnimationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newsticker_pack)

        // UI references.
        val tool = findViewById<Toolbar>(R.id.toolbar1)
        tool.title = "Sticker"
        setSupportActionBar(tool)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        nameEdit = findViewById(R.id.sticker_pack_name_edit)
        empty = findViewById(R.id.animation_view)
        authorEdit = findViewById(R.id.sticker_pack_author_edit)
        val btnCreate = findViewById<FrameLayout>(R.id.btn_create_pack)
        btnCreate.setOnClickListener { v: View? ->
            with(empty) { this?.setVisibility(View.GONE) }
            FishBun.with(this@NewStickerPackActivity)
                .setImageAdapter(GlideAdapter())
                .setMaxCount(30)
                .exceptGif(true)
                .setActionBarColor(
                    Color.parseColor("#fead00"),
                    Color.parseColor("#fead00"),
                    false
                )
                .setMinCount(3).setActionBarTitleColor(Color.parseColor("#ffffff"))
                .startAlbum()
        }

        val gridview = findViewById<GridView>(R.id.sticker_pack_grid_images_preview)


        gridview.onItemClickListener =
            OnItemClickListener { parent: AdapterView<*>?, v: View?, position: Int, id: Long ->
                Toast.makeText(this@NewStickerPackActivity, "Image removed", Toast.LENGTH_SHORT)
                    .show()
            }

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.new_stickerpack_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.save_sticker_pack) {
            if (validateValues()) {
                Toast.makeText(this, "You have to fill all empty spaces", Toast.LENGTH_SHORT).show()
            } else {


            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun validateValues(): Boolean {
        return nameEdit?.getText().toString().trim { it <= ' ' }.isEmpty() || authorEdit?.getText()
            .toString().trim { it <= ' ' }.isEmpty()
    }


}

