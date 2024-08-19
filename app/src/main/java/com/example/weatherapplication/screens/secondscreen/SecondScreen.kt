package com.example.weatherapplication.screens.secondscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.R

@Preview(showBackground = true)
@Composable
fun SecondScreen() {
    Column {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            items(7) { days ->
                DailyCard(
                    title = "WN",
                    image = ImageVector.vectorResource(R.drawable.baseline_sunny_24),
                    maxValue = "12",
                    minValue = "10"
                )
            }
        }
        DailyInfo(
            modifier = Modifier,
            dayOfWeek = "Sunday",
            month = "August",
            number = "11",
            maxTemp = "21",
            minTemp = "7",
            image = ImageVector.vectorResource(R.drawable.baseline_cloudy_snowing_24),
            currentWeather = "Cloudy"
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            items(7) { hourInfo ->
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

