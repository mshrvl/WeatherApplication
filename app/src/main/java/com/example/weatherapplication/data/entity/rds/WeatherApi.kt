package com.example.weatherapplication.data.entity.rds

import com.example.weatherapplication.data.entity.entity.WeatherResponse
import com.example.weatherapplication.data.entity.entity.WeatherWeekly
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("https://api.open-meteo.com/v1/forecast")
    suspend fun getWeatherDaily(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") hourly: List<String>,
        @Query("timezone") timezone: String,
        @Query("daily") daily:List<String>
    ):Response<WeatherResponse>

    suspend fun getWeatherWeekly(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("timezone") timezone: String,
        @Query("daily") daily:List<String>
    ):Response<WeatherWeekly>
}
