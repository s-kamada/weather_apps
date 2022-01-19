package com.example.weather_competition_1632

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        Row(Modifier.padding(4.dp)) {
            Image(
                painterResource(R.drawable.ic_cloudy),
                "cloudy",
                Modifier.size(24.dp)
            )
            Text(text = "どんよりとした雲")
        }
        Text(text = "-3℃")
        Text(text = "最高 4℃ / 最低 -5℃")
        Text(text = "1013 hPa 69%")
        Row(Modifier.padding(4.dp)) {
            Image(
                painterResource(id = R.drawable.ic_wind_soutuheast),
                "southeast",
                Modifier.size(8.dp)
            )
            Text(text = "南西 0.5 m/s")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Weather_competitionTheme {
        WeatherCard("青森市")
    }
}
