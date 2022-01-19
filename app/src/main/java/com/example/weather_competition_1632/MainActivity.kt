package com.example.weather_competition_1632

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.weather_competition_1632.ui.theme.Weather_competitionTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Weather_competitionTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun WeatherCard(prefectureName: String) {
    Column {
        Text(text = prefectureName)
        Text(text = "どんよりとした雲")
        Text(text = "-3℃")
        Text(text = "最高 4℃ / 最低 -5℃")
        Text(text = "1013 hPa 69%")
        Text(text = "南西 0.5 m/s")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Weather_competitionTheme {
        WeatherCard("青森市")
    }
}
