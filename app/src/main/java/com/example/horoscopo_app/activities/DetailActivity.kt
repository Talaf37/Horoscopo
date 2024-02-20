package com.example.horoscopo_app.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.horoscopo_app.R
class DetailActivity : AppCompatActivity() {

    lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        infoTextView = findViewById(R.id.infoTextView)

        val name = intent.getStringExtra("HOROSCOPO_NAME")
        infoTextView.text = name
    }
}