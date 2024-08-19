package com.example.weatherapplication.screens.secondscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import com.example.weatherapplication.ui.theme.WeatherApplicationTheme

@Composable
fun HourlyCard(
    modifier: Modifier,
    temperature: String,
    rainPercentage: String,
    image: ImageVector,
    hour: String
) {
    Column(modifier = Modifier.background(color = Color.White), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "$temperature°", fontSize = 12.sp)
        Text(text = "$rainPercentage%",fontSize = 12.sp)
        Image(imageVector = image, contentDescription = null)
        Text(text = "$hour PM",fontSize = 12.sp)
    }

}

@Preview
@Composable
fun HourlyCardPreview() {
    WeatherApplicationTheme {
        HourlyCard(
            modifier = Modifier,
            temperature = "24",
            rainPercentage = "12",
            image = ImageVector.vectorResource(
                R.drawable.baseline_sunny_24
            ),
            hour = "12"
        )
    }
}