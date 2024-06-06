package com.example.tp3_fickleflight_grupo7.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.entities.Destination

class DestinationHolder(v: View): RecyclerView.ViewHolder(v) {

        private var view1: View

        init {
            this.view1 = v
        }

        fun bind (destination: Destination){
            val txt: TextView = view1.findViewById(R.id.text_destination)
            val txtCountry: TextView = view1.findViewById(R.id.text_country)
            val txtDuration: TextView = view1.findViewById(R.id.text_duration)
            val img: ImageView = view1.findViewById(R.id.image_destination)

            txt.text = destination.text_destination
            txtCountry.text = destination.text_country
            txtDuration.text = destination.text_duration
            img.setImageResource(destination.imageResId)
        }
}