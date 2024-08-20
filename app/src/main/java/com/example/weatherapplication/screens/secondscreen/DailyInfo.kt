package com.example.weatherapplication.screens.secondscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun DailyInfo(
    modifier: Modifier,
    dayOfWeek: String,
    month: String,
    number: String,
    maxTemp: String,
    minTemp: String,
    image: ImageVector,
    currentWeather: String
) {
    Row(modifier.background(color = Color.White, shape = RoundedCornerShape(8.dp))) {
        Column(modifier = Modifier.fillMaxWidth(1f).padding(36.dp)) {
            Row {
                Text(text = "$dayOfWeek,", fontSize = 32.sp)
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Text(text = month, fontSize = 32.sp)
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Text(text = number, fontSize = 32.sp)
            }
            Row {
                Text(text = "$maxTemp°/", fontSize = 40.sp)
                Text(text = "$minTemp°", fontSize = 40.sp)
                Image(modifier = Modifier.padding(start = 36.dp).size(48.dp),imageVector = image, contentDescription = null)
            }
            Row {
                Text(text = currentWeather, fontSize = 36.sp)
            }
        }
    }
}
@Preview
@Composable
fun PreviewDailyInfo() {
    WeatherApplicationTheme {
        DailyInfo(
            modifier = Modifier,
            dayOfWeek = "Sunday" ,
            month = "August",
            number = "12",
            maxTemp ="12",
            minTemp = "9",
            image = ImageVector.vectorResource(R.drawable.baseline_sunny_24),
            currentWeather = "Sunny"
        )
    }
}


