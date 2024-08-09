package com.example.weatherapplication.screens.firstscreen

import com.example.weatherapplication.data.entity.rds.WeatherApi

class WeatherRepository(private val weatherApi: WeatherApi) {

    suspend fun getCurrentData() {
        weatherApi.getWeatherDaily(
            latitude = 52.52,
            longitude = 13.41,
            hourly = arrayOf("temperature_2m,rain,pressure_msl,surface_pressure,wind_speed_10m, uv_index,is_day"),
            timezone = "Europe%2FMoscow"
        )
    }

}