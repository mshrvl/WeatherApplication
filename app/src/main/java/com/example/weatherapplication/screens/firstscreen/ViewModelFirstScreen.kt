package com.example.weatherapplication.screens.firstscreen


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.data.entity.entity.WeatherDay
import com.example.weatherapplication.data.entity.rds.WeatherApi
import kotlinx.coroutines.launch

class ViewModelFirstScreen(private val repository: WeatherRepository) : ViewModel() {
    val data = repository.getCurrentConditions()

    var dailyData = mutableStateOf<WeatherDay?>(null)

    fun getDailyData() {
        viewModelScope.launch {
            dailyData.value = repository.getWeatherDay()

        }
    }


}