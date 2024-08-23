package com.example.weatherapplication.screens.firstscreen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.repository.WeatherRepository
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
                        temperature = response.current?.temperature2m.toString(),
                        windSpeed = response.current?.windSpeed10m.toString(),
                        pressure = response.current?.surfacePressure.toString(),
                        dayOrNight = response.current?.isDay?.let { it1 -> formatDay(it1)}.toString(),
                        sunrise = formatTime(response.daily?.sunrise?.firstOrNull()?: "")?.getFormattedTime() ?: "Ошибка данных",
                        sunset = formatTime(response.daily?.sunset?.firstOrNull()?: "")?.getFormattedTime() ?: "Ошибка данных",
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