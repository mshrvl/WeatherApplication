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
import androidx.compose.foundation.pager.rememberPagerState
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
fun SecondScreen(

) {
    val viewModel: SecondScreenViewModel = koinViewModel()
    val result by viewModel.weeklyData.collectAsState()




    Column(modifier = Modifier
        .background(Color.Blue.copy(alpha = 0.4f))
        .fillMaxSize(1f)
        .statusBarsPadding()) {
        Text(modifier = Modifier
            .padding(top = 20.dp)
            .align(Alignment.CenterHorizontally), fontSize = 20.sp, text = "10-days forecast")
        val weatherList = listOf("first", "second")
        LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp), contentPadding = PaddingValues(horizontal = 16.dp)) {

            items(weatherList) { daily ->
                daily.

            }
            items(1) { days ->
                DailyCard(
                    daysOfWeek = "WN",
                    image = ImageVector.vectorResource(R.drawable.baseline_sunny_24),
                    maxValue = result.temperatureMax,
                    minValue = result.temperatureMin
                )
            }
        }
        Spacer(modifier = Modifier.padding(4.dp))
        DailyInfo(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            dayOfWeek = "Sunday",
            month = "August",
            number = "11",
            maxTemp = "21",
            minTemp = "7",
            image = ImageVector.vectorResource(R.drawable.baseline_cloudy_snowing_24),
            currentWeather = "Cloudy"
        )
        Text(modifier = Modifier.padding(8.dp), text = "Hourly forecast", fontSize = 16.sp)
            LazyRow(modifier = Modifier.padding(2.dp),horizontalArrangement = Arrangement.spacedBy(4.dp), contentPadding = PaddingValues(horizontal = 16.dp)) {
                items(24) { hourInfo ->
                    HourlyCard(
                        modifier = Modifier,
                        temperature = "12",
                        rainPercentage = "30",
                        image = ImageVector.vectorResource(
                            R.drawable.baseline_cloudy_snowing_24
                        ),
                        hour = "9"
                    )

                }

            }
        }
    }
