package com.example.weatherapplication.screens.firstscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBarDefaults
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
import com.example.weatherapplication.ui.theme.Purple40
import com.example.weatherapplication.ui.theme.PurpleGrey40
import com.example.weatherapplication.ui.theme.White
import org.koin.dsl.module


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
                .background(Color.Gray)
                .weight(0.5f)
                .size(160.dp)


        )
        {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_sunny_24),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 96.dp, top = 50.dp)
                    .size(52.dp)

            )

            Text(text = "Sunny", modifier = Modifier.padding(top = 16.dp, start = 16.dp))
            Text(text = "15C", fontSize = 36.sp, modifier = Modifier.padding(top = 50.dp, start = 20.dp))
            Text(text = "Some text some text", fontSize = 8.sp, modifier = Modifier.padding(top = 90.dp, start = 25.dp)
            )


        }
        Spacer(modifier = Modifier.padding(4.dp))
        Box(modifier = Modifier
            .weight(0.5f)
            .background(Purple40)) {


            Text(text = "Wind", modifier = Modifier.padding(start = 16.dp, top = 8.dp))
            Image(modifier = Modifier
                .size(36.dp)
                .padding(16.dp),imageVector = ImageVector.vectorResource(id = R.drawable.baseline_cloudy_snowing_24), contentDescription = null )
        }


    }
}

