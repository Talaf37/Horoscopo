package com.example.horoscopo_app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo_app.data.HoroscopoProvider
import com.example.horoscopo.adapters.HoroscopoAdapter
import com.example.horoscopo_app.R
import com.example.horoscopo_app.R.string
import com.example.horoscopo_app.data.Horoscopo

class MainActivity : AppCompatActivity() {

    private val horoscopoList : List<Horoscopo> = HoroscopoProvider().getHoroscopos()

    lateinit var horoscopoAdapter: HoroscopoAdapter

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        recyclerView = findViewById(R.id.recyclerView)

        horoscopoAdapter = HoroscopoAdapter(horoscopoList) {
            onItemClickListener(it)
        }
        //recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = horoscopoAdapter
    }

    private fun onItemClickListener(position:Int) {
        val horoscopo:Horoscopo = horoscopoList[position]

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("HOROSCOPE_ID", horoscopo.id)
        startActivity(intent)
        Toast.makeText(this, getString(horoscopo.name), Toast.LENGTH_LONG).show()
    }
}