package com.example.weatherapplication.screens.secondscreen

import androidx.lifecycle.ViewModel
import com.example.weatherapplication.repository.WeatherRepository

class SecondScreenViewModel(private val repository: WeatherRepository) : ViewModel() {
    val data = repository
}