package com.example.weatherapplication.screens.secondscreen

import android.health.connect.datatypes.units.Percentage
import android.health.connect.datatypes.units.Temperature
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.repository.WeatherRepository
import com.example.weatherapplication.screens.firstscreen.FirstScreenState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class SecondScreenState(
    val time: String = " ",
    val temperatureMax: String = " ",
    val temperatureMin: String = " ",
    val rainPercentage: String = " ",
    val weatherCode: String = " ",
    val dailyCards: List<DailyCard> = listOf(),
    val isLoading: Boolean = true
)

data class DailyCard(val date: String, val temperatureMax: String, val temperatureMin: String)


class SecondScreenViewModel(private val repository: WeatherRepository) : ViewModel() {
    val data = repository.getWeeklyConditions()
    private val _weeklyData = MutableStateFlow(SecondScreenState())
    val weeklyData = _weeklyData.asStateFlow()
    private fun getWeeklyData() {
        viewModelScope.launch {
            delay(5000)
            val response = repository.getWeatherWeekly()
            response?.let { response ->
                //response.weatherHourly
//                _weeklyData.update {
//                    it.copy(
//                        time = response.weatherHourly.time,
//                        temperatureMax = response.weatherHourly.temperatureMax.toString(),
//                        temperatureMin = response.weatherHourly.temperatureMin.toString(),
//                        rainPercentage = response.weatherHourly.rainProbability.toString(),
//                        weatherCode = response.weatherHourly.weatherCode.toString(),
//                        isLoading = false
//                    )
//                }

            }
        }
    }
    private fun formatWeatherCode(weatherCode: Int) : String {
        return when (weatherCode) {
            0 -> "Clear sky"
            1,2,3 -> "Partly cloudly"
            45,48 -> "Fog"
            51,53,55 -> "Drizzle"
            56,57 -> "Freezing Drizzle"
            61,63,65 -> "Rain"
            66,67 -> "Freezing rain"
            71,73,75 -> "Snow fall"
            77 -> "Snow grains"
            80,81,82 -> "Rain showers"
            85,86 -> "Snow showers"
            else -> ""
        }
    }
    init {
        getWeeklyData()
    }
}

