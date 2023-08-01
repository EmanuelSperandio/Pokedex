package com.esperandio.pokedex.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.esperandio.pokedex.R
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageBackgroundURL = "https://lh3.googleusercontent.com/u/0/drive-viewer/AITFw-wVggueU5YdllFplFQgdKf4_uwW_3PfnWRspmPK1OzEOaaYrK7Kq-7kK0pVDCUK6V9enkInYqkU02Sgn1i139B_0_nF=w1879-h939"
        val backgroundImageView : ImageView = findViewById(R.id.main_activity_background)

        Picasso.get().load(imageBackgroundURL).fit().into(backgroundImageView)

        backgroundImageView.setOnClickListener {
            val intent = Intent(this, PokedexActivity::class.java)
            startActivity(intent)
        }

    }

}