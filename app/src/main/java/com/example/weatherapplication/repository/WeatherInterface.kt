package com.example.weatherapplication.repository

import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.data.entity.entity.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.concurrent.Flow

interface WeatherInterface {
    fun getCurrentConditions(): MutableLiveData<WeatherResponse?>
    fun getWeeklyConditions(): MutableStateFlow<WeatherResponse?>
}