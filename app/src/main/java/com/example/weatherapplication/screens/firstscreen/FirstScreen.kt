package com.example.weatherapplication.screens.firstscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.R
import com.example.weatherapplication.ui.theme.Purple40
import com.example.weatherapplication.ui.theme.White


@Preview(showBackground = true)
@Composable
fun FirstScreen() {
    Row(modifier = Modifier
        .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically) {

        Box(modifier = Modifier
            .background(Purple40))
        {
            Text(text = "10")
            Image(imageVector = ImageVector.vectorResource(id = R.drawable.baseline_sunny_24), contentDescription = null)

        }
        Spacer(modifier = Modifier.padding(8.dp))

        Box(modifier = Modifier
            .background(Purple40)) {
            Text(text = "10")

        }
    }
    Spacer(modifier = Modifier
        .padding(8.dp))
    Row(modifier = Modifier
        .padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier){
            Text(text = "10")

        }
        Box(modifier = Modifier){
            Text(text = "20")

        }

    }

}