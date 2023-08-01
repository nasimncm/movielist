package com.example.yesmachintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MovieDetails : AppCompatActivity() {
    private var image: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val appCompatImageView = findViewById<ImageView>(R.id.appCompatImageView)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvRealname = findViewById<TextView>(R.id.tvRealname)
        val tvTeamname = findViewById<TextView>(R.id.tvTeamname)
        val tvFirstappearance = findViewById<TextView>(R.id.tvFirstappearance)
        val tvCreatedby = findViewById<TextView>(R.id.tvCreatedby)
        val tvPublisher = findViewById<TextView>(R.id.tvPublisher)
        val tvBio = findViewById<TextView>(R.id.tvBio)


        image =intent.getStringExtra("imageurl")
        Glide.with(this).load(image).into(appCompatImageView)
        tvName.text = intent.getStringExtra("name")
        tvRealname.text = intent.getStringExtra("realname")
        tvTeamname.text = intent.getStringExtra("team")
        tvFirstappearance.text = intent.getStringExtra("firstappearance")
        tvCreatedby.text = intent.getStringExtra("createdby")
        tvPublisher.text = intent.getStringExtra("publisher")
        tvBio.text = intent.getStringExtra("bio")
    }
}