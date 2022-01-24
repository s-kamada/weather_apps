package com.example.weather_competition_1632

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.weather_competition_1632.ui.theme.AppTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                Contents()
            }
        }
    }

    @Composable
    fun Contents() {
        val buttonPading = dimensionResource(id = R.dimen.button_padding)
        val weatherBusinessModel = remember { mutableStateOf(WeatherBusinessModel.mock()) }//WeatherBusinessModel.mock()

        // A surface container using the 'background' color from the theme
        Surface(
            color = MaterialTheme.colors.background,
        ) {
            // 背景画像を重ねる
            Image(
                painter = painterResource(id = weatherBusinessModel.value.weather.background()),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            IconButton(
                onClick = { weatherBusinessModel.value = WeatherBusinessModel.mock() },
                modifier = Modifier.padding(buttonPading)
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_refresh), contentDescription = "")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WeatherCard(weatherBusinessModel.value)
                OneDayForecast(weatherBusinessModel.value.oneDayForecast)
                WeeklyForecast(weatherBusinessModel.value.weeklyForecast)
            }
        }
    }
}
