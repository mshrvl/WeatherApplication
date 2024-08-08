package com.example.weatherapplication.data.entity.rds

import com.example.weatherapplication.data.entity.entity.WeatherDay

class RemoteDataSource (private val weatherApi: WeatherApi) {

    // step 3 - get data from web/retrofit
    suspend fun getWeatherDay(): WeatherDay {
        return weatherApi.getWeather(
            latitude = 52.52,
            longitude = 13.41,
        )
    }
}