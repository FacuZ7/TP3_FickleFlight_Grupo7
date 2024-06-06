package com.example.tp3_fickleflight_grupo7.holders

import SharedPreferencesModule
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.entities.Destination
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DestinationHolder @Inject constructor(
    v: View,
    private val sharedPreferencesModule: SharedPreferencesModule
) : RecyclerView.ViewHolder(v) {

    private var view1: View = v

    private val favoriteButton: ToggleButton = view1.findViewById(R.id.favorite_button)
    init { favoriteButton.setOnClickListener{
        val sharedPreferences = sharedPreferencesModule.provideSharedPreferences(view1.context)
        sharedPreferences.edit().putBoolean("like_${adapterPosition}", favoriteButton.isChecked).apply()
    }}



        fun bind (destination: Destination){
            val txt: TextView = view1.findViewById(R.id.text_destination)
            val txtCountry: TextView = view1.findViewById(R.id.text_country)
            val txtDuration: TextView = view1.findViewById(R.id.text_duration)
            val img: ImageView = view1.findViewById(R.id.image_destination)

            txt.text = destination.text_destination
            txtCountry.text = destination.text_country
            txtDuration.text = destination.text_duration
            img.setImageResource(destination.imageResId)
            val sharedPreferences = sharedPreferencesModule.provideSharedPreferences(view1.context)
            val isLiked = sharedPreferences.getBoolean("like_${adapterPosition}", false)
            favoriteButton.isChecked = isLiked
        }
}