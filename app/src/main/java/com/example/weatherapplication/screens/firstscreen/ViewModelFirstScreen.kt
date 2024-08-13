package com.example.weatherapplication.screens.firstscreen


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.data.entity.entity.WeatherResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewModelFirstScreen(private val repository: WeatherRepository) : ViewModel() {
    val data = repository.getCurrentConditions()
    var dailyData = mutableStateOf<WeatherResponse?>(null)

    private fun getDailyData() {
        viewModelScope.launch {
            delay(5000)
            dailyData.value = repository.getWeatherCurrent()
        }
    }

    init {
        getDailyData()
    }

}