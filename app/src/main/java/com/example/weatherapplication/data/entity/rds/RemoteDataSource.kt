package com.example.weatherapplication.data.entity.rds

import com.example.weatherapplication.data.entity.entity.WeatherDay

class RemoteDataSource(private val weatherApi: WeatherApi) {

    // step 3 - get data from web/retrofit
    suspend fun getWeatherDay(): WeatherDay {
        return weatherApi.getWeatherDaily(
            latitude = 52.52,
            longitude = 13.41,
            hourly = arrayOf("temperature_2m,rain,pressure_msl,surface_pressure,wind_speed_10m, uv_index,is_day"),
            timezone = "Europe%2FMoscow"
        )
    }
}