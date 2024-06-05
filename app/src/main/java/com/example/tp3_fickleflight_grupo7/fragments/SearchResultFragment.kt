package com.example.tp3_fickleflight_grupo7.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.MainActivity
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.adapter.FlightAdapter
import com.example.tp3_fickleflight_grupo7.entities.Airport
import com.example.tp3_fickleflight_grupo7.entities.Flight

class SearchResultFragment : Fragment() {

    lateinit var view3: View
    lateinit var recycler: RecyclerView
    //lateinit var backButton: Button

    private var flights: MutableList<Flight> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view3 = inflater.inflate(R.layout.recycler_flight_results, container, false)
        recycler = view3.findViewById(R.id.recycler_flights_result)
        //backButton = view3.findViewById(R.id.flight_button_back)


        val airport1 = Airport(
            airport_id = "LIS",
            airport_name = "Lisbon Airport",
            time = "10:00",
        )
        val airport2 = Airport(
            airport_id = "MAD",
            airport_name = "Madrid Airport",
            time = "12:30",
        )

        val airport3 = Airport(
            airport_id = "EZE",
            airport_name = "Ezeiza Airport",
            time = "16:00",
        )

        val airport4 = Airport(
            airport_id = "JFK",
            airport_name = "John F. Kennedy Airport",
            time = "20:00",
        )

        val flight1 = Flight(
            departure_airport = airport1,
            arrival_airport = airport2,
            duration = "2h 30m",
            airplane = "Boeing 737",
            airline = "Iberia",
            logo = "R.drawable.airline_default",
            travel_class = "Economy",
            flight_number = "IB 1234",
            legroom = "Standard",
            extensions = listOf("In-flight meal", "Wi-Fi", "Entertainment")

        )

        val flight2 = Flight(
            departure_airport = airport3,
            arrival_airport = airport4,
            duration = "10h 30m",
            airplane = "Airbus A380",
            airline = "American Airlines",
            logo = "R.drawable.airline_default",
            travel_class = "Business",
            flight_number = "AA 5678",
            legroom = "Extra",
            extensions = listOf("In-flight meal", "Wi-Fi", "Entertainment", "Lounge access")

        )

        val flight3 = Flight(
            departure_airport = airport2,
            arrival_airport = airport3,
            duration = "1h 30m",
            airplane = "Airbus A320",
            airline = "Iberia",
            logo = "R.drawable.airline_default",
            travel_class = "Economy",
            flight_number = "IB 5678",
            legroom = "Standard",
            extensions = listOf("In-flight meal", "Wi-Fi")

        )

        val flight4 = Flight(
            departure_airport = airport4,
            arrival_airport = airport1,
            duration = "8h 30m",
            airplane = "Boeing 777",
            airline = "American Airlines",
            logo = "R.drawable.airline_default",
            travel_class = "Business",
            flight_number = "AA 1234",
            legroom = "Extra",
            extensions = listOf("In-flight meal", "Wi-Fi", "Entertainment", "Lounge access")

        )

        for (i in 1..10) {
            flights.add(flight1)
            flights.add(flight2)
            flights.add(flight3)
            flights.add(flight4)
        }

        recycler.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context)
        val flightAdapter = FlightAdapter(flights)
        recycler.layoutManager = linearLayoutManager
        recycler.adapter = flightAdapter
        return view3
    }

}