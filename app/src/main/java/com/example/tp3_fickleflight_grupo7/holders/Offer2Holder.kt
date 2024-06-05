package com.example.tp3_fickleflight_grupo7.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R

class Offer2Holder(view: View) : RecyclerView.ViewHolder(view){
    private val cardTitle: TextView = view.findViewById(R.id.card_title)
    private val cardText: TextView = view.findViewById(R.id.card_text)
    private val leftImage: ImageView = view.findViewById(R.id.left_image)
    private val rightIcon: ImageView = view.findViewById(R.id.right_icon)


    fun bind(title: String, text: String, leftImageId: Int, rightIconId: Int) {
        cardTitle.text = title
        cardText.text = text
        leftImage.setImageResource(leftImageId)
        rightIcon.setImageResource(rightIconId)
    }


}