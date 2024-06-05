package com.example.tp3_fickleflight_grupo7.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.adapter.FlightAdapter
import com.example.tp3_fickleflight_grupo7.entities.BestFlight
import com.example.tp3_fickleflight_grupo7.entities.FlightResponse
import com.example.tp3_fickleflight_grupo7.interfaces.FlightApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchResultFragment : Fragment() {

    lateinit var view3: View
    lateinit var recycler: RecyclerView
    //lateinit var backButton: Button

    private var flights: MutableList<BestFlight> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateFlights()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view3 = inflater.inflate(R.layout.recycler_flight_results, container, false)
        recycler = view3.findViewById(R.id.recycler_flights_result)
        //backButton = view3.findViewById(R.id.flight_button_back)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://d9811bf4-5e67-4a8c-bdcf-603cbbfc0275.mock.pstmn.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val flightApi = retrofit.create(FlightApi::class.java)

        flightApi.getFlights().enqueue(object : Callback<FlightResponse> {
            override fun onResponse(call: Call<FlightResponse>, response: Response<FlightResponse>) {
                if (response.isSuccessful) {
                    val flightResponse = response.body()
                    if (flightResponse != null ) {
                        flights = flightResponse.best_flights.toMutableList()
                        recycler.adapter = FlightAdapter(flights)
                        recycler.adapter?.notifyDataSetChanged()
                    } else {
                        Log.e("Error", "Response body or flights is null")
                    }
                }
            }

            override fun onFailure(call: Call<FlightResponse>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

        } )
        recycler.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context)
        val flightAdapter = FlightAdapter(flights)
        recycler.layoutManager = linearLayoutManager
        recycler.adapter = flightAdapter




        return view3



    }

    private fun updateFlights() {
        val flightApi = Retrofit.Builder()
            .baseUrl("https://d9811bf4-5e67-4a8c-bdcf-603cbbfc0275.mock.pstmn.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FlightApi::class.java)

        flightApi.getFlights().enqueue(object : Callback<FlightResponse> {
            override fun onResponse(call: Call<FlightResponse>, response: Response<FlightResponse>) {
                if (response.isSuccessful) {
                    val flightResponse = response.body()
                    if (flightResponse != null) {
                        flights.clear()
                        flights.addAll(flightResponse.best_flights)
                        recycler.adapter?.notifyDataSetChanged()
                    } else {
                        Log.e("Error", "Response body or flights is null")
                    }
                }
            }

            override fun onFailure(call: Call<FlightResponse>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }
        })
    }


}