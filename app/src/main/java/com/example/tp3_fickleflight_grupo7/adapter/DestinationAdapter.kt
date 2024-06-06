package com.example.tp3_fickleflight_grupo7.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.entities.Destination
import com.example.tp3_fickleflight_grupo7.holders.DestinationHolder

class DestinationAdapter(
    private val destinations: MutableList<Destination>
    ,private val onClick: (Destination) -> Unit //funcionalidad de onclick
) : RecyclerView.Adapter<DestinationHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_destination, parent, false)
        return DestinationHolder(view)
    }

    override fun onBindViewHolder(holder: DestinationHolder, position: Int) {
        holder.bind(destinations[position])
        holder.itemView.setOnClickListener{ onClick(destinations[position])}
    }

    override fun getItemCount() = destinations.size
}