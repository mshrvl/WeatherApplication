package com.example.weatherapplication.data.entity.lds

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.data.entity.entity.WeatherResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LocalDataSource(context: Context) {

    private val gson = Gson()
    private val typeToken =
        TypeToken.getParameterized(List::class.java, WeatherResponse::class.java).type
    private val filename = "weatherDailyData.json"
    private var weatherDailyData: WeatherResponse? = null
    val dayData = MutableLiveData(weatherDailyData)

    init {
        val file = context.filesDir.resolve(filename)
        if (file.exists()) {
            context.openFileInput(filename).bufferedReader().use {
                weatherDailyData = gson.fromJson(it, typeToken)
                dayData.value = weatherDailyData
            }
        }
    }
}