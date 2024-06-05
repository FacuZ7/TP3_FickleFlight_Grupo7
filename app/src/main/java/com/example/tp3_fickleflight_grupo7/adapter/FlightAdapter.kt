package com.example.tp3_fickleflight_grupo7.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.entities.BestFlight
import com.example.tp3_fickleflight_grupo7.holders.FlightHolder


class FlightAdapter(private val flights: MutableList<BestFlight>) : RecyclerView.Adapter<FlightHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flight_item, parent, false)
        return FlightHolder(view)
    }

    override fun onBindViewHolder(holder: FlightHolder, position: Int) {
        if(position < flights.size) {
        val bestFlight = flights[position]
        for (flight in bestFlight.flights) {
            holder.setDepartureAirport(
                flight.departure_airport?.airport_name,
                flight.departure_airport?.airport_id
            )
            holder.setArrivalAirport(
                flight.arrival_airport?.airport_name,
                flight.arrival_airport?.airport_id
            )
            holder.setDuration(flight.duration, flight.airplane)
            holder.setAirline(flight.airline)
            holder.setTravelClass(flight.travel_class)
            flight.airline_logo?.let { holder.setLogo(it) }

        }


        }
    }

    override fun getItemCount(): Int {
        var totalFlights = 0
        for (bestFlight in flights) {
            totalFlights += bestFlight.flights.size
        }
        return totalFlights
    }
}
