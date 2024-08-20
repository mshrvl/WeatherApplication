package com.example.weatherapplication.screens.secondscreen

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import com.example.weatherapplication.ui.theme.WeatherApplicationTheme


@Composable
fun DailyCard(modifier: Modifier = Modifier, daysOfWeek: String, image: ImageVector, maxValue: String, minValue: String) {
    Column(
        modifier = Modifier.background(color = Color.White, shape = RoundedCornerShape(8.dp)).padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = daysOfWeek, fontSize = 24.sp)
        Image(modifier = Modifier.size(30.dp), imageVector = image, contentDescription = null)
        Row() {
            Text(text = "$maxValue°/", fontSize = 24.sp)
            Text(text = "$minValue°", fontSize = 24.sp)
        }
    }
}
@Preview
@Composable
fun DailyCardPreview() {
    WeatherApplicationTheme {
        DailyCard(
            daysOfWeek = "WN",
            image = ImageVector.vectorResource(id = R.drawable.baseline_sunny_24),
            maxValue = "12",
            minValue = "23"
        )
    }
}