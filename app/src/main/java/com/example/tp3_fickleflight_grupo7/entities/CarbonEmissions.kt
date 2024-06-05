package com.example.tp3_fickleflight_grupo7.entities

data class CarbonEmissions(
    val this_flight: Int,
    val typical_for_this_route: Int,
    val difference_percent: Int
)
