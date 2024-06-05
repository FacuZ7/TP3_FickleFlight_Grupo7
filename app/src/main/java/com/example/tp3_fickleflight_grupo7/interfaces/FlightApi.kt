package com.example.tp3_fickleflight_grupo7.interfaces

import com.example.tp3_fickleflight_grupo7.entities.FlightResponse
import retrofit2.Call
import retrofit2.http.GET

interface FlightApi {
    @GET("search?engine=google_flights&api_key=123&departure_id=EZE&arrival_id=MIA&outbound_date=2024-05-31&return_date=2024-06-10/")
    fun getFlights(): Call<FlightResponse>
}