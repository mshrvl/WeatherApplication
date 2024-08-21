package com.example.weatherapplication.screens.secondscreen

import androidx.lifecycle.ViewModel
import com.example.weatherapplication.repository.WeatherRepository
import com.example.weatherapplication.screens.firstscreen.FirstScreenState
import kotlinx.coroutines.flow.MutableStateFlow




class SecondScreenViewModel(private val repository: WeatherRepository) : ViewModel() {
    val data = repository.getWeeklyConditions()
    //private val _weeklyData = MutableStateFlow(SecondScreenState)
    //val weeklyData = _weeklyData.asStateFlow()

}