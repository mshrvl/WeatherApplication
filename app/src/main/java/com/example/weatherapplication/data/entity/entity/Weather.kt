package com.example.weatherapplication.data.entity.entity

import com.example.weatherapplication.screens.firstscreen.formatTime
import com.example.weatherapplication.screens.firstscreen.getFormattedTime
import com.google.gson.annotations.SerializedName


data class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    @SerializedName("current")
    val currentWeather: CurrentWeather,
    @SerializedName("daily")
    val sunrisesSunset: Daily
) {
    fun getFirstDaySunrise(): String? {
        this.sunrisesSunset.sunrise.firstOrNull()?.let {
            return formatTime(it)?.getFormattedTime()
        }
        return null
    }

    fun getFirstDaySunset(): String? {
        this.sunrisesSunset.sunset.firstOrNull()?.let {
            return formatTime(it)?.getFormattedTime()
        }
        return null
    }
}

data class CurrentWeather(
    val time: String,
    @SerializedName("temperature_2m")
    val temperature: Double,
    @SerializedName("is_day")
    val isDay: Int,
    val rain: Int,
    @SerializedName("weather_code")
    val weatherCode: Int,
    @SerializedName("surface_pressure")
    val surfacePressure: Double,
    @SerializedName("wind_speed_10m")
    val windSpeed: Double,
)

data class Daily(
    val sunset: List<String>,
    val sunrise: List<String>
)


data class WeatherWeekly(
    val latitude: Double,
    val longitude: Double,
    val timezone: String
)
