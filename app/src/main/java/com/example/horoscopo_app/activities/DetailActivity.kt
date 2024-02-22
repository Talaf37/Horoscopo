package com.example.horoscopo_app.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.horoscopo_app.R
import com.example.horoscopo_app.data.Horoscopo
import com.example.horoscopo_app.data.HoroscopoProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    private var currentHoroscopoIndex:Int = -1
    private var horoscopoId:String? = null
    private lateinit var horoscopo:Horoscopo

    private lateinit var horoscopoTextView:TextView
    private lateinit var horoscopoImageView:ImageView
    private lateinit var horoscopoLuckTextView:TextView
    private lateinit var progress:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        horoscopoId = intent.getStringExtra("HOROSCOPE_ID")
        horoscopo = HoroscopoProvider().getHoroscopo(horoscopoId!!)
        currentHoroscopoIndex = HoroscopoProvider().getHoroscopoIndex(horoscopo)

        initView()

        loadData()
    }

    private fun initView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        horoscopoTextView = findViewById(R.id.horoscopoTextView)
        horoscopoImageView = findViewById(R.id.horoscopoImageView)
        horoscopoLuckTextView = findViewById(R.id.horoscopoLuckTextView)
        progress = findViewById(R.id.progress)
    }

    private fun loadData() {
        horoscopo = HoroscopoProvider().getHoroscopo(currentHoroscopoIndex)

        // Set title
        supportActionBar?.setTitle(horoscopo.name)
        supportActionBar?.setSubtitle(horoscopo.dates)

        horoscopoTextView.text = getString(horoscopo.name)
        horoscopoImageView.setImageResource(horoscopo.image)

        getHoroscopeLuck()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.horoscopo_menu, menu)
        return true
    }

    // this event will enable the back
    // function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.menu_prev -> {
                if (currentHoroscopoIndex == 0) {
                    currentHoroscopoIndex = HoroscopoProvider().getHoroscopos().size
                }
                currentHoroscopoIndex--
                loadData()
                return true
            }
            R.id.menu_next -> {
                currentHoroscopoIndex ++
                if (currentHoroscopoIndex == HoroscopoProvider().getHoroscopos().size) {
                    currentHoroscopoIndex = 0
                }
                loadData()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getHoroscopeLuck() {
        progress.visibility = View.VISIBLE
        horoscopoLuckTextView.text = ""
        CoroutineScope(Dispatchers.IO).launch {
            // Llamada en segundo plano
            val result = HoroscopoProvider().getHoroscopoLuck(horoscopo.id)
            runOnUiThread {
                // Modificar UI
                horoscopoLuckTextView.text = result
                progress.visibility = View.GONE
            }
        }
    }
}