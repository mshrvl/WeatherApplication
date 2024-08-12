package com.example.weatherapplication.screens.firstscreen

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.data.entity.entity.WeatherDay
import com.example.weatherapplication.data.entity.lds.LocalDataSource
import com.example.weatherapplication.data.entity.rds.RemoteDataSource
import com.example.weatherapplication.data.entity.rds.WeatherApi
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class WeatherRepository(
    private val weatherApi: WeatherApi,
    private val context: Context,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) :
    WeatherInterface {
    suspend fun getWeatherDay() = remoteDataSource.getWeatherDay()

//    suspend fun getWeatherDay() {
//        weatherApi.getWeatherDaily(
//            latitude = 52.52,
//            longitude = 13.41,
//            hourly = arrayOf("temperature_2m,rain,pressure_msl,surface_pressure,wind_speed_10m, uv_index,is_day"),
//            timezone = "Europe%2FMoscow"
//        )
//    }


    private val gson = Gson()
    private val typeToken =
        TypeToken.getParameterized(List::class.java, WeatherDay::class.java).type
    private val filename = "weatherDailyData.json"
    private var weatherDailyData: WeatherDay? = null
    private val dayData = MutableLiveData(weatherDailyData)


    init {
        val file = context.filesDir.resolve(filename)
        if (file.exists()) {
            context.openFileInput(filename).bufferedReader().use {
                weatherDailyData = gson.fromJson(it, typeToken)
                dayData.value = weatherDailyData
            }
        }
    }

    override fun getCurrentConditions(): MutableLiveData<WeatherDay?> = dayData
}
