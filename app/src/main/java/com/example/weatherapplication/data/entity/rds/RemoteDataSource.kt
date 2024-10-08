package com.example.weatherapplication.data.entity.rds

import com.example.weatherapplication.data.entity.entity.WeatherResponse

class RemoteDataSource(private val weatherApi: WeatherApi) {
    suspend fun getWeatherCurrent(): WeatherResponse? {
        val response = weatherApi.getWeatherDaily(
            latitude = 59.9386,
            longitude = 30.3141,
            hourly = listOf(
                "temperature_2m",
                "is_day",
                "rain",
                "surface_pressure",
                "wind_speed_10m"
            ),
            timezone = "Europe/Moscow",
            daily = listOf("sunrise", "sunset")
        )
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

    suspend fun getWeatherWeekly(): WeatherResponse? {
        val response = weatherApi.getWeatherWeekly(
            latitude = 59.9386,
            longitude = 30.3141,
            timezone = "Europe/Moscow",
            daily = listOf(
                "weather_code",
                "temperature_2m_max",
                "temperature_2m_min",
                "precipitation_probability_max"
            ),
            hourly = listOf("temperature_2m", "precipitation_probability")
        )
        if (response.isSuccessful) {
            return response.body()
        }
        return null

    }
}