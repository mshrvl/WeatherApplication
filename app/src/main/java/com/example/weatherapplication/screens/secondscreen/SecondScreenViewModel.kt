package com.example.weatherapplication.screens.secondscreen


import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.repository.WeatherRepository
import com.example.weatherapplication.screens.firstscreen.areDatesSameDay
import com.example.weatherapplication.screens.firstscreen.formateDate
import com.example.weatherapplication.screens.firstscreen.formateDateToMonthAndDay
import com.example.weatherapplication.screens.firstscreen.getFormattedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import kotlin.math.roundToInt


data class SecondScreenState(
    val time: String = " ",
    val temperatureMax: String = " ",
    val temperatureMin: String = " ",
    val rainPercentage: String = " ",
    val weatherCode: String = " ",
    val dailyCards: List<DailyCard> = listOf(),
    val hourlyCards: List<HourlyCard> = listOf(),
    val selectedDay: String = "abc",
    val isLoading: Boolean = true
)

data class DailyCard(val date: String, val temperatureMax: String, val temperatureMin: String)
data class HourlyCard(val hour: String, val hourlyTemperature: String, val probability: String)

class SecondScreenViewModel(private val repository: WeatherRepository) : ViewModel() {
    //val data = repository.getWeeklyConditions()
    //val hourlydata = repository.getWeeklyConditions()

    private val _uiState = MutableStateFlow(SecondScreenState())
    val state = _uiState.asStateFlow()

    fun selectDay(date: String) {

        // TODO: обновить состояние краточки
        // TODO: обновить состояние листа погоды по часам
        _uiState.update {
            it.copy(selectedDay = date)
        }
        getHourlyData(date)
    }

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
            response.let { response ->
                _uiState.update {
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

    private fun getHourlyData(selectedDay: String = "2024-08-30") {
        val stf = SimpleDateFormat("yyyy-MM-dd")
        val selectedDayDate = stf.parse(selectedDay)

        viewModelScope.launch {
            val response = repository.getWeatherWeekly()
            val listHourly = with(response?.hourly!!) {
                time.mapIndexed { index, d ->
                    Log.d("checkMap", "check: ${d}")
                    val date = formateDate(d!!)!!
                    if (areDatesSameDay(selectedDayDate, date)) {
                        HourlyCard(
                            hour = formateDateToMonthAndDay(date).toString(),
                            hourlyTemperature = temperature2m?.get(index)?.roundToInt().toString(),
                            probability = precipitationProbability?.get(index).toString()
                        )
                    } else null
                }.filterNotNull()
            }

            response.let { response ->

                _uiState.update {
                    Log.d("checkMaplistHourly", "update")
                    it.copy(
                        hourlyCards = listHourly
                    )
                }
            }
        }
    }

    init {
        getWeeklyData()
        getHourlyData()

    }

}


private fun formatWeatherCode(weatherCode: Int): String {
    return when (weatherCode) {
        0 -> "Clear sky"
        1, 2, 3 -> "Partly cloudly"
        45, 48 -> "Fog"
        51, 53, 55 -> "Drizzle"
        56, 57 -> "Freezing Drizzle"
        61, 63, 65 -> "Rain"
        66, 67 -> "Freezing rain"
        71, 73, 75 -> "Snow fall"
        77 -> "Snow grains"
        80, 81, 82 -> "Rain showers"
        85, 86 -> "Snow showers"
        else -> "Unknown code"
    }
}

