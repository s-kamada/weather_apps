package com.example.weather_competition_1632

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather_competition_1632.ui.theme.AppTheme
import com.example.weather_competition_1632.ui.theme.Texts

@Composable
fun WeatherCard(prefectureName: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Texts.Header(text = prefectureName)
        Row(Modifier.padding(4.dp)) {
            Image(
                painterResource(R.drawable.ic_cloudy),
                "cloudy",
                Modifier.size(24.dp)
            )
            Texts.Body(text = "どんよりとした雲")
        }
        Texts.Header(text = "-3℃")
        Texts.Description(text = "最高 4℃ / 最低 -5℃")
        Texts.Description(text = "1013 hPa 69%")
        Row(Modifier.padding(4.dp)) {
            Image(
                painterResource(id = R.drawable.ic_wind_soutuheast),
                "southeast",
                Modifier.size(8.dp).border(1.5.dp, MaterialTheme.colors.background)
            )
            Texts.Description(text = "南西 0.5 m/s")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        WeatherCard("青森市")
    }
}
