package com.example.tp3_fickleflight_grupo7.entities

data class BestFlight(
    val flights: List<Flight>,
    val layovers: List<Layover>,
    val total_duration: Int,
    val carbon_emissions: CarbonEmissions,
    val price: Int,
    val type: String,
    val airline_logo: String,
    val departure_token: String
)

