package com.example.weatherapplication.screens.secondscreen


import android.health.connect.datatypes.units.Temperature
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapplication.repository.WeatherRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


data class SecondScreenState(
    val time: String = " ",
    val temperatureMax: String = " ",
    val temperatureMin: String = " ",
    val rainPercentage: String = " ",
    val weatherCode: String = " ",
    val dailyCards: List<DailyCard> = listOf(),
    val hourlyCards: List <HourlyCard> = listOf(),
    val isLoading: Boolean = true
)

data class DailyCard(val date: String, val temperatureMax: String, val temperatureMin: String)
data class HourlyCard(val hour: String, val hourlyTemperature: String, val probability: String)

class SecondScreenViewModel(private val repository: WeatherRepository) : ViewModel() {
    //val data = repository.getWeeklyConditions()
    val hourlydata = repository.getHourlyConditions()
    private val _weeklyData = MutableStateFlow(SecondScreenState())
    val weeklyData = _weeklyData.asStateFlow()
    private fun getWeeklyData() {
        viewModelScope.launch {
            delay(5000)
            val response = repository.getWeatherWeekly()
            val listDaily = with(response?.daily!!) {
                time!!.mapIndexed { index, s ->
                    DailyCard(
                        date = s!!,
                        temperatureMax = temperature2mMax[index]?.roundToInt().toString(),
                        temperatureMin = temperature2mMin[index]?.roundToInt().toString()
                    )
                }
            }
            val listHourly = with(response.hourly) {

            }
            response.let { response ->
                _weeklyData.update {
                    it.copy(
                        time = response.daily?.time.toString(),
                        temperatureMax = response.daily?.temperature2mMax.toString(),
                        temperatureMin = response.daily?.temperature2mMin.toString(),
                        rainPercentage = response.hourly?.precipitationProbability.toString(),
                        weatherCode = response.daily?.weatherCode.toString(),
                        dailyCards = listDaily,
                        isLoading = true
                    )
                }
            }
        }
    }
    private fun getHourlyData() {
        viewModelScope.launch {
            delay(5000)
            val response = repository.getHourlyConditions()
            //val listHourly = with()
        }
    }

//    private fun formatWeatherCode(weatherCode: List<Int>): String {
//        return when (weatherCode) {
//            0 -> "Clear sky"
//            1, 2, 3 -> "Partly cloudly"
//            45, 48 -> "Fog"
//            51, 53, 55 -> "Drizzle"
//            56, 57 -> "Freezing Drizzle"
//            61, 63, 65 -> "Rain"
//            66, 67 -> "Freezing rain"
//            71, 73, 75 -> "Snow fall"
//            77 -> "Snow grains"
//            80, 81, 82 -> "Rain showers"
//            85, 86 -> "Snow showers"
//            else -> ""
//        }
//    }

    init {
        getWeeklyData()
    }

    init {
        getHourlyData()
    }
}

