package com.example.weatherapplication.data.entity.entity

import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep


@Keep
data class WeatherResponse(
    @SerializedName("current")
    val current: Current?,
    @SerializedName("current_units")
    val currentUnits: CurrentUnits?,
    @SerializedName("daily")
    val daily: Daily?,
    @SerializedName("daily_units")
    val dailyUnits: DailyUnits?,
    @SerializedName("elevation")
    val elevation: Int?,
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double?,
    @SerializedName("hourly")
    val hourly: Hourly?,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("timezone")
    val timezone: String?,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String?,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int?
)

@Keep
data class Current(
    @SerializedName("interval")
    val interval: Int?,
    @SerializedName("is_day")
    val isDay: Int?,
    @SerializedName("rain")
    val rain: Float?,
    @SerializedName("temperature_2m")
    val temperature2m: Double?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("weather_code")
    val weatherCode: Int?,
    @SerializedName("wind_speed_10m")
    val windSpeed10m: Double?,
    @SerializedName("surface_pressure")
    val surfacePressure: Double?
)

@Keep
data class CurrentUnits(
    @SerializedName("interval")
    val interval: String?,
    @SerializedName("is_day")
    val isDay: String?,
    @SerializedName("rain")
    val rain: String?,
    @SerializedName("temperature_2m")
    val temperature2m: String?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("weather_code")
    val weatherCode: String?,
    @SerializedName("wind_speed_10m")
    val windSpeed10m: String?
)

@Keep
data class Daily(
    @SerializedName("precipitation_probability_max")
    val precipitationProbabilityMax: List<Int?>?,
    @SerializedName("sunrise")
    val sunrise: List<String?>?,
    @SerializedName("sunset")
    val sunset: List<String?>?,
    @SerializedName("temperature_2m_max")
    val temperature2mMax: List<Double?>,
    @SerializedName("temperature_2m_min")
    val temperature2mMin: List<Double?>,
    @SerializedName("time")
    val time: List<String?>?,
    @SerializedName("weather_code")
    val weatherCode: List<Int?>
)

@Keep
data class DailyUnits(
    @SerializedName("precipitation_probability_max")
    val precipitationProbabilityMax: String?,
    @SerializedName("sunrise")
    val sunrise: String?,
    @SerializedName("sunset")
    val sunset: String?,
    @SerializedName("temperature_2m_max")
    val temperature2mMax: String?,
    @SerializedName("temperature_2m_min")
    val temperature2mMin: String?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("weather_code")
    val weatherCode: String?
)

@Keep
data class Hourly(
    @SerializedName("precipitation_probability")
    val precipitationProbability: List<Int?>?,
    @SerializedName("surface_pressure")
    val surfacePressure: List<Double?>?,
    @SerializedName("temperature_2m")
    val temperature2m: List<Double?>?,
    @SerializedName("time")
    val time: List<String?>,
    @SerializedName("weather_code")
    val weatherCode: List<Int?>?,
    @SerializedName("wind_speed_10m")
    val windSpeed10m: List<Double?>?
)

@Keep
data class HourlyUnits(
    @SerializedName("precipitation_probability")
    val precipitationProbability: String,
    @SerializedName("surface_pressure")
    val surfacePressure: String?,
    @SerializedName("temperature_2m")
    val temperature2m: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("weather_code")
    val weatherCode: String,
    @SerializedName("wind_speed_10m")
    val windSpeed10m: String?
)























