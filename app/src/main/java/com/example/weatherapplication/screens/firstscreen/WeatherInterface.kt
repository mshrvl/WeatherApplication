package com.example.weatherapplication.screens.firstscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.data.entity.entity.WeatherDay

interface WeatherInterface {
    fun getCurrentConditions(): MutableLiveData<WeatherDay?>
}