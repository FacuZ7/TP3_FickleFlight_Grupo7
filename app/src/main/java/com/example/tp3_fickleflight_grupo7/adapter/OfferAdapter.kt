package com.example.tp3_fickleflight_grupo7.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.entities.Offer
import com.example.tp3_fickleflight_grupo7.holders.Offer1Holder
import com.example.tp3_fickleflight_grupo7.holders.Offer2Holder

class OfferAdapter(private val items: MutableList<Offer>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val OFFER_1 = 0
        private const val OFFER_2 = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            OFFER_1
        } else {
            OFFER_2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            OFFER_1 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.offer_card, parent, false)
                Offer1Holder(view)
            }
            OFFER_2 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.offer_card_2, parent, false)
                Offer2Holder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is Offer1Holder -> {
                // Enlaza los datos a la vista para offer_card
                holder.bind(item.title, item.text, item.leftImageId, item.rightIconId)
            }
            is Offer2Holder -> {
                // Enlaza los datos a la vista para offer_card_2
                holder.bind(item.title, item.text, item.leftImageId, item.rightIconId)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}