package com.example.weatherapplication.screens.secondscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import org.koin.androidx.compose.koinViewModel


@Composable
fun SecondScreen() {
    val viewModel: SecondScreenViewModel = koinViewModel()
    val state by viewModel.state.collectAsState() // ладно)
    val dailyList = state.dailyCards
    val hourlyList = state.hourlyCards
    Column(
        modifier = Modifier
            .background(Color.Blue.copy(alpha = 0.4f))
            .fillMaxSize(1f)
            .statusBarsPadding()
    ) {
        Text(
            modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.CenterHorizontally), fontSize = 20.sp, text = "7-days forecast"
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(dailyList) {
                DailyCard(
                    daysOfWeek = it.date.toString(),
                    image = ImageVector.vectorResource(R.drawable.baseline_sunny_24),
                    maxValue = it.temperatureMax,
                    minValue = it.temperatureMin,
                    onClick = {
                        viewModel.selectDay(it.date, it.temperatureMax, it.temperatureMin, it.currentCondition)
                    }
                )
            }
        }
        Spacer(modifier = Modifier.padding(4.dp))
        DailyInfo(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            dayOfWeek = state.selectedDay,
            month = "",
            number = "",
            maxTemp = state.selectedTempMax,
            minTemp = state.selectedTempMin,
            image = ImageVector.vectorResource(R.drawable.baseline_cloudy_snowing_24),
            currentWeather = state.weatherCondition
        )
        Text(modifier = Modifier.padding(8.dp), text = "Hourly forecast", fontSize = 16.sp)
        LazyRow(
            modifier = Modifier.padding(2.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(hourlyList) {
                HourlyCard(
                    modifier = Modifier,
                    temperature = it.hourlyTemperature,
                    rainPercentage = it.probability,
                    image = ImageVector.vectorResource(
                        R.drawable.baseline_cloudy_snowing_24
                    ),
                    hour = it.hour
                )

            }

        }
    }
}
