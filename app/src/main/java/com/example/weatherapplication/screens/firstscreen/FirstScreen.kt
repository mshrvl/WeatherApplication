package com.example.weatherapplication.screens.firstscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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

@Preview(showBackground = true)
@Composable
fun FirstScreen() {
    Text(text = "Current conditions", modifier = Modifier.padding(top = 30.dp))
    Row( modifier = Modifier
        .padding(top = 50.dp),
        Arrangement.SpaceEvenly

        ) {

         Box(
            modifier = Modifier
                .background(Color.LightGray, shape = RoundedCornerShape(6.dp))
                .weight(0.5f)
                .size(160.dp)


        )
        {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_sunny_24),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 110.dp, top = 50.dp)
                    .size(50.dp)

            )

            Text(text = "Sunny", modifier = Modifier.padding(top = 16.dp, start = 16.dp))
            Text(text = "22°C", fontSize = 36.sp, modifier = Modifier.padding(top = 50.dp, start = 20.dp))
            Text(text = "Some text some text", fontSize = 8.sp, modifier = Modifier.padding(top = 100.dp, start = 25.dp)
            )


        }
        Spacer(modifier = Modifier.padding(4.dp))
        Box(modifier = Modifier
            .background(Color.LightGray, shape = RoundedCornerShape(6.dp))
            .weight(0.5f)
            .size(160.dp)) {

            Image(modifier = Modifier
                .size(100.dp)
                .padding(start = 10.dp, top = 50.dp),imageVector = ImageVector.vectorResource(id = R.drawable.baseline_cloudy_snowing_24), contentDescription = null )



            Text(text = "Wind", modifier = Modifier.padding(start = 16.dp, top = 8.dp))
            Text(text = "East", modifier = Modifier.padding(start = 36.dp,top = 18.dp))

        }
    }
    Row(modifier = Modifier
        .padding(top = 220.dp),
        Arrangement.SpaceEvenly) {

        Box(modifier = Modifier
            .background(color = Color.LightGray, shape = RoundedCornerShape(6.dp))
            .size(160.dp)
            .weight(0.5f))

        Spacer(modifier = Modifier.padding(4.dp))

        Box(modifier = Modifier
            .background(color = Color.LightGray, shape = RoundedCornerShape(6.dp))
            .size(160.dp)
            .weight(0.5f))

    }

    Row(modifier = Modifier.padding(top = 390.dp)) {
        Box(modifier = Modifier
            .background(color = Color.LightGray, shape = RoundedCornerShape(6.dp))
            .size(150.dp)
            .weight(1f))
    }

    Row(modifier = Modifier.padding(top = 550.dp)) {
        Box(modifier = Modifier
            .background(color = Color.LightGray, shape = RoundedCornerShape(6.dp))
            .size(150.dp)
            .weight(1f))

    }
}

