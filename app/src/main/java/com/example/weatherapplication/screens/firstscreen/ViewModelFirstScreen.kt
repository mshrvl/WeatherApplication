package com.example.weatherapplication.screens.firstscreen


import android.health.connect.datatypes.units.Temperature
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.data.entity.entity.WeatherResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class FirstScreenState(
    val temperature: String = " ".repeat(15),
    val windSpeed: String = " ".repeat(15),
    val pressure: String = " ".repeat(15),
    val dayOrNight: String = " ".repeat(15),
    val sunrise: String = " ".repeat(15),
    val sunset: String = " ".repeat(15),
    val isLoading: Boolean = true
)

class ViewModelFirstScreen(private val repository: WeatherRepository) : ViewModel() {
    val data = repository.getCurrentConditions()
    private val _dailyData = MutableStateFlow(FirstScreenState())
    val dailyData = _dailyData.asStateFlow()
    private fun getDailyData() {
        viewModelScope.launch {
            delay(5000)
            val response = repository.getWeatherCurrent()
            response?.let { response ->
                _dailyData.update {
                    it.copy(
                        temperature = response.currentWeather.temperature.toString(),
                        windSpeed = response.currentWeather.windSpeed.toString(),
                        pressure = response.currentWeather.surfacePressure.toString(),
                        dayOrNight = formatDay(response.currentWeather.isDay),
                        sunrise = response.getFirstDaySunrise()?: "Ошибка данных",
                        sunset = response.getFirstDaySunset()?: "Ошибка данных",
                        isLoading = false
                    )
                }
            }
        }
    }

    private fun formatDay(dayOrNight: Int) : String {
        return when(dayOrNight) {
            1 -> "Day"
            2 -> "Night"
            else -> ""
        }
    }

    init {
        getDailyData()
    }
}