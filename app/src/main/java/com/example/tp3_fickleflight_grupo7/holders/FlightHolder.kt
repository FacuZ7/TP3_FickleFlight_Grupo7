package com.example.tp3_fickleflight_grupo7.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R


class FlightHolder(v: View): RecyclerView.ViewHolder(v) {

    private var view: View

    init {
        this.view = v
    }

    fun setDepartureAirport(departureAirport: String?, departureCode: String?) {
        val txt: TextView = view.findViewById(R.id.departure_name)
        val txtCode: TextView = view.findViewById(R.id.departure_code)
        txt.text = departureAirport
        txtCode.text = departureCode
    }

    fun setArrivalAirport(arrivalAirport: String?, arrivalCode: String?){
        val txt: TextView = view.findViewById(R.id.arrival_name)
        val txtCode: TextView = view.findViewById(R.id.arrival_code)
        txt.text = arrivalAirport
        txtCode.text = arrivalCode
    }

    fun setDuration(duration: String?, icon: String?){
        val txt: TextView = view.findViewById(R.id.flight_duration)
        val img: ImageView = view.findViewById(R.id.duration_icon)
        txt.text = duration
        if (icon != null) {
            img.setImageResource(icon.toInt())
        }
    }

    /*fun setAirplane(airplane: String?){
        val txt: TextView = view.findViewById(R.id.airplane)
        txt.text = airplane
    }*/

    fun setAirline(airline: String?){
        val txt: TextView = view.findViewById(R.id.airline_name)
        txt.text = airline
    }

    fun setLogo(logo: String){
        val img: ImageView = view.findViewById(R.id.airline_logo)
        img.setImageResource(logo.toInt())
    }

    fun setTravelClass(travelClass: String?){
        val txt: TextView = view.findViewById(R.id.class_price_info)
        txt.text = travelClass
    }


}