package com.example.horoscopo_app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo_app.data.HoroscopoProvider
import com.example.horoscopo.adapters.HoroscopoAdapter
import com.example.horoscopo_app.R
import com.example.horoscopo_app.data.Horoscopo

class MainActivity : AppCompatActivity() {

    private var horoscopoList : List<Horoscopo> = HoroscopoProvider().getHoroscopos()

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
        //Lo comento para que no me haga nada
        //Toast.makeText(this, getString(horoscopo.name), Toast.LENGTH_LONG).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        //"Inflo" el menu, esto añade items a la barra si esta presente
        initSearchView(menu?.findItem(R.id.menu_search))

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initSearchView(searchItem: MenuItem?) {
        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    horoscopoList = if (query.isNullOrEmpty()) {
                        HoroscopoProvider().getHoroscopos()
                    } else {
                        HoroscopoProvider().getHoroscopos()
                            .filter { getString(it.name).contains(query, true) }
                    }
                    horoscopoAdapter.updateData(horoscopoList)
                    return true
                }
            })
        }
    }
}