package com.example.tp3_fickleflight_grupo7.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.entities.Flight
import com.example.tp3_fickleflight_grupo7.holders.FlightHolder


class FlightAdapter(private val flights: MutableList<Flight>) : RecyclerView.Adapter<FlightHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flight_item, parent, false)
        return FlightHolder(view)
    }

    override fun onBindViewHolder(holder: FlightHolder, position: Int) {
        val flight = flights[position]
        holder.setDepartureAirport(flight.departure_airport?.airport_name, flight.departure_airport?.airport_id)
        holder.setArrivalAirport(flight.arrival_airport?.airport_name, flight.arrival_airport?.airport_id)
        holder.setDuration(flight.duration, R.drawable.clock.toString())
        holder.setAirline(flight.airline)
        holder.setTravelClass(flight.travel_class)
        flight.logo?.let { holder.setLogo(it) }


    }

    override fun getItemCount(): Int {
        return flights.size
    }
}
