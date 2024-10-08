package com.example.weatherapplication.screens.firstscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import com.example.weatherapplication.ui.theme.WeatherApplicationTheme

@Composable
fun WeatherBigCard(
    modifier: Modifier = Modifier,
    title: String,
    sunriseTime: String,
    sunsetTime: String,
    image: ImageVector,
    placeholderVisible: Boolean
) {
    Column(modifier = modifier.background(color = Color.White, shape = RoundedCornerShape(16.dp))) {
        Text(modifier = Modifier.padding(16.dp), text = title)

        Spacer(modifier = Modifier.padding(bottom = 16.dp))
        Row {

            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = "Sunrise")
                Text(modifier = Modifier.basePlaceholder(placeholderVisible), text = sunriseTime, fontSize = 30.sp)
                Spacer(modifier = Modifier.padding(4.dp))
                Text(text = "Sunset")
                Text(modifier = Modifier.basePlaceholder(placeholderVisible), text = sunsetTime, fontSize = 30.sp)
            }
            Image(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(124.dp)
                    .padding(end = 16.dp)
                    .weight(1f),
                imageVector = image,
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun WeatherBigCardPreview() {
    WeatherApplicationTheme {
        WeatherBigCard(
            title = "Sunrise sunset",
            sunriseTime = "2222",
            sunsetTime = "2222",
            image = ImageVector.vectorResource(R.drawable.sunset_6wykko949zcr) ,
            placeholderVisible = false
        )
    }
}