package com.example.weatherapplication.screens.firstscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun FirstScreen(
    viewModel: ViewModelFirstScreen = koinViewModel()
) {
    val result by viewModel.dailyData
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue.copy(alpha = 0.4f))
    ) {
        Text(text = "Current conditions", modifier = Modifier.statusBarsPadding())
        Row(
            modifier = Modifier
                .padding(top = 4.dp)
                .padding(horizontal = 16.dp),
            Arrangement.SpaceEvenly
        ) {
            WeatherCard(
                modifier = Modifier
                    .weight(1f)
                    .height(160.dp),
                title = "Temperature",
                value = result?.currentWeather?.temperature.toString() + "°С",
                supportText = "Light",
                image = ImageVector.vectorResource(R.drawable.baseline_cloudy_snowing_24)
            )
            Spacer(modifier = Modifier.width(4.dp))
            WeatherCard(
                modifier = Modifier
                    .weight(1f)
                    .height(160.dp),
                title = "Wind Speed",
                value = if (result?.currentWeather?.windSpeed == 0.0) {
                    "No wind"
                } else result?.currentWeather?.windSpeed.toString(),
                supportText = "km/h",
                image = ImageVector.vectorResource(R.drawable.baseline_sunny_24)
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 4.dp)
                .padding(horizontal = 16.dp),
            Arrangement.SpaceEvenly
        ) {
            WeatherCard(
                modifier = Modifier
                    .weight(1f)
                    .height(160.dp),
                title = "Pressure",
                value = result?.currentWeather?.surfacePressure.toString(),
                supportText = "mBar",
                image = ImageVector.vectorResource(R.drawable.baseline_sunny_24)
            )
            Spacer(modifier = Modifier.width(4.dp))
            WeatherCard(
                modifier = Modifier
                    .weight(1f)
                    .height(160.dp),
                title = "Day or Night",
                value = when (result?.currentWeather?.isDay) {
                    1 -> "Day"
                    0 -> "Night"
                    else -> {
                        "null"
                    }
                },
                supportText = "",
                image = ImageVector.vectorResource(R.drawable.baseline_cloudy_snowing_24)
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            //WeatherBigCard()
            Spacer(modifier = Modifier.padding(4.dp))
            //WeatherBigCard()
        }
    }
}



