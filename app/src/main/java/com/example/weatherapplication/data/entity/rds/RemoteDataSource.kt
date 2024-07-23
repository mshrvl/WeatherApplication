package com.example.weatherapplication.data.entity.rds

import com.example.weatherapplication.data.entity.entity.Weather

class RemoteDataSource (val weatherApi: WeatherApi) {

    // step 3 - get data from web/retrofit
    suspend fun getInsult(): Weather {
        return weatherApi.getWeather(
            latitude = 52.52F,
            longitude = 13.41F,
        )
    }
}