package com.example.tp3_fickleflight_grupo7.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R


class FlightHolder(v: View): RecyclerView.ViewHolder(v) {

    private var view1: View

    init {
        this.view1 = v
    }

    fun setDepartureAirport(departureAirport: String?, departureCode: String?) {
        val txt: TextView = view1.findViewById(R.id.departure_name)
        val txtCode: TextView = view1.findViewById(R.id.departure_code)
        txt.text = departureAirport
        txtCode.text = departureCode
    }

    fun setArrivalAirport(arrivalAirport: String?, arrivalCode: String?){
        val txt: TextView = view1.findViewById(R.id.arrival_name)
        val txtCode: TextView = view1.findViewById(R.id.arrival_code)
        txt.text = arrivalAirport
        txtCode.text = arrivalCode
    }

    fun setDuration(duration: Int?, icon: String?){
        val txt: TextView = view1.findViewById(R.id.flight_duration)
        val img: ImageView = view1.findViewById(R.id.duration_icon)
        txt.text = duration.toString()

        if (icon != null) {
            val resourceId = view1.context.resources.getIdentifier(icon, "drawable", view1.context.packageName)
            img.setImageResource(resourceId)
        }
    }

    /*fun setAirplane(airplane: String?){
        val txt: TextView = view.findViewById(R.id.airplane)
        txt.text = airplane
    }*/

    fun setAirline(airline: String?){
        val txt: TextView = view1.findViewById(R.id.airline_name)
        txt.text = airline
    }

    fun setLogo(logo: String){
        val img: ImageView = view1.findViewById(R.id.airline_logo)
        /*
        if (logo != null){
            img.setImageResource(logo.toInt())
        }
        */
    }

    fun setTravelClass(travelClass: String?){
        val txt: TextView = view1.findViewById(R.id.class_price_info)
        txt.text = travelClass
    }


}