package com.example.tp3_fickleflight_grupo7.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R

class OfferHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val cardTitle: TextView = view.findViewById(R.id.card_title)
    private val cardText: TextView = view.findViewById(R.id.card_text)
    private val leftImage: ImageView = view.findViewById(R.id.left_image)
    private val rightIcon: ImageView? = view.findViewById(R.id.right_icon)
    private val limitedOfferTextView: TextView? = view.findViewById(R.id.offer_label)

    fun bind(
        title: String,
        text: String,
        leftImageId: Int,
        rightIconId: Int?,
        isLimitedOffer: Boolean
    ) {
        cardTitle.text = title
        cardText.text = text
        leftImage.setImageResource(leftImageId)
        rightIconId?.let { rightIcon?.setImageResource(it) }

        if (isLimitedOffer) {
            limitedOfferTextView?.visibility = View.VISIBLE
        } else {
            limitedOfferTextView?.visibility = View.GONE
        }
    }

}