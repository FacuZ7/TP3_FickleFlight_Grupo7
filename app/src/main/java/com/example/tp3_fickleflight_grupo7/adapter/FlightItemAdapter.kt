package com.example.tp3_fickleflight_grupo7.adapter

import Flight
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tp3_fickleflight_grupo7.R

class FlightItemAdapter(private val flights: List<Flight>) : RecyclerView.Adapter<FlightItemAdapter.FlightHolder>() {

    inner class FlightHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val departureAirport: TextView = view.findViewById(R.id.departure_name)
        private val departureCode: TextView = view.findViewById(R.id.departure_code)
        private val arrivalAirport: TextView = view.findViewById(R.id.arrival_name)
        private val arrivalCode: TextView = view.findViewById(R.id.arrival_code)
        private val duration: TextView = view.findViewById(R.id.flight_duration)
        private val airline: TextView = view.findViewById(R.id.airline)
        private val logo: ImageView = view.findViewById(R.id.airline_logo)
        private val travelClass: TextView = view.findViewById(R.id.class_price_info)

        fun bind(flight: Flight) {
            departureAirport.text = flight.departure_airport.name.take(15)
            departureCode.text = flight.departure_airport.id
            arrivalAirport.text = flight.arrival_airport.name.take(15)
            arrivalCode.text = flight.arrival_airport.id
            val hours = flight.duration / 60
            val minutes = flight.duration % 60
            duration.text = "${hours}h ${minutes}m"

            airline.text = flight.airline
            Glide.with(itemView.context).load(flight.airline_logo).into(logo)
            travelClass.text = flight.travel_class
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flight_item, parent, false)
        return FlightHolder(view)
    }

    override fun onBindViewHolder(holder: FlightHolder, position: Int) {
        val flight = flights[position]
        holder.bind(flight)
    }

    override fun getItemCount(): Int = flights.size
}