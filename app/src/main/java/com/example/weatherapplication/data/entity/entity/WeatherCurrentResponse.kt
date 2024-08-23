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
    val temperature2mMax: List<Double?>?,
    @SerializedName("temperature_2m_min")
    val temperature2mMin: List<Double?>?,
    @SerializedName("time")
    val time: List<String?>?,
    @SerializedName("weather_code")
    val weatherCode: List<Int?>?
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
    val time: List<String?>?,
    @SerializedName("weather_code")
    val weatherCode: List<Int?>?,
    @SerializedName("wind_speed_10m")
    val windSpeed10m: List<Double?>?
)

@Keep
data class HourlyUnits(
    @SerializedName("precipitation_probability")
    val precipitationProbability: String?,
    @SerializedName("surface_pressure")
    val surfacePressure: String?,
    @SerializedName("temperature_2m")
    val temperature2m: String?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("weather_code")
    val weatherCode: String?,
    @SerializedName("wind_speed_10m")
    val windSpeed10m: String?
)























//@Keep
//data class WeatherResponse(
//    @SerializedName("daily")
//    val daily: Daily?,
//    @SerializedName("daily_units")
//    val dailyUnits: DailyUnits?,
//    @SerializedName("elevation")
//    val elevation: Double?,
//    @SerializedName("generationtime_ms")
//    val generationtimeMs: Double?,
//    @SerializedName("hourly")
//    val hourly: Hourly?,
//    @SerializedName("hourly_units")
//    val hourlyUnits: HourlyUnits?,
//    @SerializedName("latitude")
//    val latitude: Double?,
//    @SerializedName("longitude")
//    val longitude: Double?,
//    @SerializedName("timezone")
//    val timezone: String?,
//    @SerializedName("timezone_abbreviation")
//    val timezoneAbbreviation: String?,
//    @SerializedName("utc_offset_seconds")
//    val utcOffsetSeconds: Int?
//) {
////        fun getFirstDaySunrise(): String? {
////        this.daily.sunrise.firstOrNull()?.let {
////            return formatTime(it)?.getFormattedTime()
////        }
////        return null
////    }
////
////    fun getFirstDaySunset(): String? {
////        this.daily.sunset.firstOrNull()?.let {
////            return formatTime(it)?.getFormattedTime()
////        }
////        return null
////    }
//}
//
//@Keep
//data class Daily(
//    @SerializedName("precipitation_probability_max")
//    val precipitationProbabilityMax: List<Int?>?,
//    @SerializedName("temperature_2m_max")
//    val temperature2mMax: List<Double?>?,
//    @SerializedName("temperature_2m_min")
//    val temperature2mMin: List<Double?>?,
//    @SerializedName("time")
//    val time: List<String?>?,
//    @SerializedName("weather_code")
//    val weatherCode: List<Int?>?
//)
//
//@Keep
//data class DailyUnits(
//    @SerializedName("precipitation_probability_max")
//    val precipitationProbabilityMax: String?,
//    @SerializedName("temperature_2m_max")
//    val temperature2mMax: String?,
//    @SerializedName("temperature_2m_min")
//    val temperature2mMin: String?,
//    @SerializedName("time")
//    val time: String?,
//    @SerializedName("weather_code")
//    val weatherCode: String?
//)
//
//@Keep
//data class Hourly(
//    @SerializedName("precipitation_probability")
//    val precipitationProbability: List<Int?>?,
//    @SerializedName("temperature_2m")
//    val temperature2m: List<Double?>?,
//    @SerializedName("time")
//    val time: List<String?>?,
//    @SerializedName("weather_code")
//    val weatherCode: List<Int?>?
//)
//
//@Keep
//data class HourlyUnits(
//    @SerializedName("precipitation_probability")
//    val precipitationProbability: String?,
//    @SerializedName("temperature_2m")
//    val temperature2m: String?,
//    @SerializedName("time")
//    val time: String?,
//    @SerializedName("weather_code")
//    val weatherCode: String?
//)
//
////data class WeatherCurrentResponse(
////    val daily: Daily,
////    val daily_units: DailyUnits,
////    val elevation: Int,
////    val generationtime_ms: Double,
////    val hourly: Hourly,
////    val hourly_units: HourlyUnits,
////    val latitude: Double,
////    val longitude: Double,
////    val timezone: String,
////    val timezone_abbreviation: String,
////    val utc_offset_seconds: Int
////)
////@Keep
//data class WeatherResponse(
//    @SerializedName("current")
//    val current: Current?,
//    @SerializedName("current_units")
//    val currentUnits: CurrentUnits?,
//    @SerializedName("daily")
//    val daily: Daily?,
//    @SerializedName("daily_units")
//    val dailyUnits: DailyUnits?,
//    @SerializedName("elevation")
//    val elevation: Int?,
//    @SerializedName("generationtime_ms")
//    val generationtimeMs: Double?,
//    @SerializedName("hourly")
//    val hourly: Hourly?,
//    @SerializedName("hourly_units")
//    val hourlyUnits: HourlyUnits?,
//    @SerializedName("latitude")
//    val latitude: Double?,
//    @SerializedName("longitude")
//    val longitude: Double?,
//    @SerializedName("timezone")
//    val timezone: String?,
//    @SerializedName("timezone_abbreviation")
//    val timezoneAbbreviation: String?,
//    @SerializedName("utc_offset_seconds")
//    val utcOffsetSeconds: Int?
//)
//
//@Keep
//data class Current(
//    @SerializedName("interval")
//    val interval: Int?,
//    @SerializedName("is_day")
//    val isDay: Int?,
//    @SerializedName("rain")
//    val rain: Int?,
//    @SerializedName("temperature_2m")
//    val temperature2m: Double?,
//    @SerializedName("time")
//    val time: String?,
//    @SerializedName("weather_code")
//    val weatherCode: Int?,
//    @SerializedName("wind_speed_10m")
//    val windSpeed10m: Double?
//)
//
//@Keep
//data class CurrentUnits(
//    @SerializedName("interval")
//    val interval: String?,
//    @SerializedName("is_day")
//    val isDay: String?,
//    @SerializedName("rain")
//    val rain: String?,
//    @SerializedName("temperature_2m")
//    val temperature2m: String?,
//    @SerializedName("time")
//    val time: String?,
//    @SerializedName("weather_code")
//    val weatherCode: String?,
//    @SerializedName("wind_speed_10m")
//    val windSpeed10m: String?
//)
//
//@Keep
//data class Daily(
//    @SerializedName("precipitation_probability_max")
//    val precipitationProbabilityMax: List<Int?>?,
//    @SerializedName("sunrise")
//    val sunrise: List<String?>?,
//    @SerializedName("sunset")
//    val sunset: List<String?>?,
//    @SerializedName("temperature_2m_max")
//    val temperature2mMax: List<Double?>?,
//    @SerializedName("temperature_2m_min")
//    val temperature2mMin: List<Double?>?,
//    @SerializedName("time")
//    val time: List<String?>?,
//    @SerializedName("weather_code")
//    val weatherCode: List<Int?>?
//)
//
//@Keep
//data class DailyUnits(
//    @SerializedName("precipitation_probability_max")
//    val precipitationProbabilityMax: String?,
//    @SerializedName("sunrise")
//    val sunrise: String?,
//    @SerializedName("sunset")
//    val sunset: String?,
//    @SerializedName("temperature_2m_max")
//    val temperature2mMax: String?,
//    @SerializedName("temperature_2m_min")
//    val temperature2mMin: String?,
//    @SerializedName("time")
//    val time: String?,
//    @SerializedName("weather_code")
//    val weatherCode: String?
//)
//
//@Keep
//data class Hourly(
//    @SerializedName("precipitation_probability")
//    val precipitationProbability: List<Int?>?,
//    @SerializedName("surface_pressure")
//    val surfacePressure: List<Double?>?,
//    @SerializedName("temperature_2m")
//    val temperature2m: List<Double?>?,
//    @SerializedName("time")
//    val time: List<String?>?,
//    @SerializedName("weather_code")
//    val weatherCode: List<Int?>?,
//    @SerializedName("wind_speed_10m")
//    val windSpeed10m: List<Double?>?
//)
//
//@Keep
//data class HourlyUnits(
//    @SerializedName("precipitation_probability")
//    val precipitationProbability: String?,
//    @SerializedName("surface_pressure")
//    val surfacePressure: String?,
//    @SerializedName("temperature_2m")
//    val temperature2m: String?,
//    @SerializedName("time")
//    val time: String?,
//    @SerializedName("weather_code")
//    val weatherCode: String?,
//    @SerializedName("wind_speed_10m")
//    val windSpeed10m: String?
//)
////data class Daily(
////    val precipitation_probability_max: List<Int>,
////    val temperature_2m_max: List<Double>,
////    val temperature_2m_min: List<Double>,
////    val time: List<String>,
////    val weather_code: List<Int>
////)
////
////data class DailyUnits(
////    val precipitation_probability_max: String,
////    val temperature_2m_max: String,
////    val temperature_2m_min: String,
////    val time: String,
////    val weather_code: String
////)
////
////data class Hourly(
////    val precipitation_probability: List<Int>,
////    val temperature_2m: List<Double>,
////    val time: List<String>,
////    val weather_code: List<Int>
////)
////
////data class HourlyUnits(
////    val precipitation_probability: String,
////    val temperature_2m: String,
////    val time: String,
////    val weather_code: String
////)
//
//
//
//
//
//
//
//
////data class WeatherResponse(
////    val latitude: Double,
////    val longitude: Double,
////    val timezone: String,
////    @SerializedName("current")
////    val currentWeather: CurrentWeather,
////    @SerializedName("daily")
////    val sunrisesSunset: Daily
////) {
////
////    fun getFirstDaySunrise(): String? {
////        this.sunrisesSunset.sunrise.firstOrNull()?.let {
////            return formatTime(it)?.getFormattedTime()
////        }
////        return null
////    }
////
////    fun getFirstDaySunset(): String? {
////        this.sunrisesSunset.sunset.firstOrNull()?.let {
////            return formatTime(it)?.getFormattedTime()
////        }
////        return null
////    }
////}
////
////data class CurrentWeather(
////    val time: String,
////    @SerializedName("temperature_2m")
////    val temperature: Double,
////    @SerializedName("is_day")
////    val isDay: Int,
////    val rain: Int,
////    @SerializedName("weather_code")
////    val weatherCode: Int,
////    @SerializedName("surface_pressure")
////    val surfacePressure: Double,
////    @SerializedName("wind_speed_10m")
////    val windSpeed: Double,
////)
////
////data class Daily(
////    val sunset: List<String>,
////    val sunrise: List<String>
////)
////
////
////data class WeatherWeekly(
////    val latitude: Double?,
////    val longitude: Double,
////    val timezone: String,
////    val daily: Daily2
////)
////
////data class Daily2(
////    val time: List<String>,
////    @SerializedName("weather_code")
////    val weatherCode: List<Int>,
////    @SerializedName("temperature_2m_max")
////    val temperatureMax: List<Double>,
////    @SerializedName("temperature_2m_min")
////    val temperatureMin: List<Double>,
////    @SerializedName("precipitation_probability_max")
////    val rainProbability: List<Int>
////)
