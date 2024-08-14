package com.example.weatherapplication.screens.firstscreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import com.example.weatherapplication.ui.theme.WeatherApplicationTheme
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.placeholder

@Composable
fun Modifier.basePlaceholder(visible: Boolean) = this.placeholder(
    visible = visible,
    color = MaterialTheme.colorScheme.secondary,
    highlight = PlaceholderHighlight.fade(MaterialTheme.colorScheme.tertiary),
    shape = RoundedCornerShape(4.dp)
)

@Composable
fun WeatherCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    supportText: String,
    image: ImageVector,

    ) {

    Row(
        modifier = modifier
            .background(color = Color.White, shape = RoundedCornerShape(16.dp)),

        ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title)
            Spacer(modifier = Modifier.height(16.dp))
            Text(modifier = Modifier.basePlaceholder(true), text = value, fontSize = 30.sp)
            Text(text = supportText)
        }

        Image(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(16.dp)
                .weight(1f)
                .aspectRatio(1f),
            imageVector = image,
            contentDescription = null
        )

    }
}

@Preview
@Composable
fun WeatherCardPreview() {
    WeatherApplicationTheme {
        WeatherCard(
            modifier = Modifier.size(160.dp),
            title = "Sunny",
            value = "15/C",
            supportText = "Light",
            image = ImageVector.vectorResource(
                R.drawable.baseline_sunny_24
            )
        )
    }
}