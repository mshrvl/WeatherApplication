package com.example.weatherapplication.screens.firstscreen

import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.data.entity.entity.WeatherResponse

interface WeatherInterface {
    fun getCurrentConditions(): MutableLiveData<WeatherResponse?>
}