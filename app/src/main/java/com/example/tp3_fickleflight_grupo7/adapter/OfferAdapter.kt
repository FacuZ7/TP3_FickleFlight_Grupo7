package com.example.tp3_fickleflight_grupo7.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.entities.Offer
import com.example.tp3_fickleflight_grupo7.holders.OfferHolder

class OfferAdapter(private val items: MutableList<Offer>,
                    private val isHorizontal: Boolean) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layoutId = if (isHorizontal) {
            R.layout.offer_card_small
        } else {
            R.layout.offer_card
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return OfferHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        (holder as OfferHolder).bind(item.title, item.text, item.leftImageId, item.rightIconId)

    }



    override fun getItemCount(): Int {
        return items.size
    }
}