package com.example.weatherapplication.data.entity.entity

data class WeatherDay(
    val latitude: Double,
    val longitude: Double,
    val hourly: Array<String>,
    val timezone: String
)

data class WeatherWeekly(
    val latitude: Double,
    val longitude: Double,
    val timezone: String
)
