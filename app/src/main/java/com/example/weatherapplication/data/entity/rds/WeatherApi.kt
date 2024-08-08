package com.example.weatherapplication.data.entity.rds

import com.example.weatherapplication.data.entity.entity.WeatherDay
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET ("https://api.open-meteo.com/v1/forecast")
    suspend fun getWeather (
        @Query ("latitude") latitude: Double,
        @Query ("longitude") longitude: Double,
    ) : WeatherDay
}
