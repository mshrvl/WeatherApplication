package com.example.weatherapplication.data.entity.rds

import com.example.weatherapplication.data.entity.entity.WeatherResponse

class RemoteDataSource(private val weatherApi: WeatherApi) {

    suspend fun getWeatherCurrent(): WeatherResponse? {
        val response = weatherApi.getWeatherDaily(
            latitude = 52.52,
            longitude = 13.41,
            hourly = listOf("temperature_2m", "is_day", "rain", "surface_pressure"),
            timezone = "Europe/Moscow"
        )
        if (response.isSuccessful) {
            return response.body()
        } else {

        }
        return null
    }
}