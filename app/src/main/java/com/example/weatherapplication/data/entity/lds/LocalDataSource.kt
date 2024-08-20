package com.example.weatherapplication.data.entity.lds

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.data.entity.entity.WeatherResponse
import com.example.weatherapplication.data.entity.entity.WeatherWeekly
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow

class LocalDataSource(context: Context) {

    private val gson = Gson()
    private val typeToken =
        TypeToken.getParameterized(List::class.java, WeatherResponse::class.java).type

    private val fileNameDaily = "weatherDailyData.json"
    private val fileNameWeek = "weatherWeeklyData.json"
    private var weatherDailyData: WeatherResponse? = null
    private var weatherWeeklyData: WeatherWeekly? = null
    val dayData = MutableLiveData(weatherDailyData)
    val weekData = MutableStateFlow(weatherDailyData)

    init {
        val file = context.filesDir.resolve(fileNameDaily)
        if (file.exists()) {
            context.openFileInput(fileNameDaily).bufferedReader().use {
                weatherDailyData = gson.fromJson(it, typeToken)
                dayData.value = weatherDailyData
            }
        }
    }
    }
