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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.R

@Preview(showBackground = true)
@Composable
fun FirstScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue.copy(alpha = 0.4f))) {
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
                title = "Pressure",
                value = "15/C",
                supportText = "Light",
                image = ImageVector.vectorResource(R.drawable.baseline_cloudy_snowing_24)
            )
            Spacer(modifier = Modifier.width(4.dp))
            WeatherCard(
                modifier = Modifier
                    .weight(1f)
                    .height(160.dp),
                title = "Sallas",
                value = "22 km/h",
                supportText = "Support",
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
                title = "Kollen",
                value = "34",
                supportText = "Jaba",
                image = ImageVector.vectorResource(R.drawable.baseline_sunny_24)
            )
            Spacer(modifier = Modifier.width(4.dp))
            WeatherCard(
                modifier = Modifier
                    .weight(1f)
                    .height(160.dp),
                title = "Alexey",
                value = "30cm",
                supportText = "BigCock",
                image = ImageVector.vectorResource(R.drawable.baseline_cloudy_snowing_24)
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            WeatherBigCard()
            Spacer(modifier = Modifier.padding(4.dp))
            WeatherBigCard()
        }
    }
}


