package com.example.horoscopo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo_app.R
import com.example.horoscopo_app.data.Horoscopo

class HoroscopoAdapter(var items:List<Horoscopo> = listOf(), val onClickListener: (position:Int) -> Unit) : RecyclerView.Adapter<HoroscopoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopoViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_horoscopo, parent, false)
        return HoroscopoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HoroscopoViewHolder, position: Int) {
        holder.render(items[position])
        holder.itemView.setOnClickListener { onClickListener(position) }
    }
    fun updateData (list:List<Horoscopo> ) {
        items = list
        notifyDataSetChanged()
    }
}

class HoroscopoViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    val horoscopoImageView:ImageView = view.findViewById(R.id.horoscopoImageView)
    val horoscopoTextView:TextView = view.findViewById(R.id.horoscopoTextView)

    fun render(horoscopo: Horoscopo) {
        val context:Context = itemView.context
        horoscopoTextView.text = context.getString(horoscopo.name)
        horoscopoImageView.setImageResource(horoscopo.image)
    }
}