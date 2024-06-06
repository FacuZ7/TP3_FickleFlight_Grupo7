package com.example.tp3_fickleflight_grupo7.adapter

import SharedPreferencesModule
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.entities.Destination
import com.example.tp3_fickleflight_grupo7.holders.DestinationHolder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DestinationAdapter @Inject constructor
    (private val destinations: MutableList<Destination>,
     private val sharedPreferences: SharedPreferencesModule) : RecyclerView.Adapter<DestinationHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_destination, parent, false)
        return DestinationHolder(view, sharedPreferences)
    }

    override fun onBindViewHolder(holder: DestinationHolder, position: Int) {
        holder.bind(destinations[position])
    }

    override fun getItemCount() = destinations.size
}