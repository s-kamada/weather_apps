package com.example.weather_competition_1632

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import com.example.weather_competition_1632.ui.theme.AppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val weatherBusinessModel = WeatherBusinessModel.mock()

        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        WeatherCard(weatherBusinessModel)
                        OneDayForecast(weatherBusinessModel.oneDayForecast)
                        WeeklyForecast(weatherBusinessModel.weeklyForecast)
                    }
                }
            }
        }
    }
}
