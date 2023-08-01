package com.example.yesmachintest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<Button>(R.id.login)
        login.setOnClickListener {
            val intent = Intent(this, MovieList::class.java)
            startActivity(intent)
        }
        val share = findViewById<Button>(R.id.share)
        share.setOnClickListener {
            val share = Intent(Intent.ACTION_SEND)
            share.type = "text/plain"
            share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
            share.putExtra(Intent.EXTRA_SUBJECT, "Mp 3 Shong")
            share.putExtra(Intent.EXTRA_TEXT, "http://pandora.yilstaging.com/writable/uploads/20210127/1611811599_2ac19cd41e8387119d7e.mp3")
            startActivity(Intent.createChooser(share, "Share link!"))
        }
    }
}