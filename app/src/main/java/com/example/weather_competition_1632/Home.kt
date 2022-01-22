package com.example.weather_competition_1632

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.weather_competition_1632.ui.theme.AppTheme
import com.example.weather_competition_1632.ui.theme.Texts

@Composable
fun WeatherCard(prefectureName: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Texts.Header(text = prefectureName)
        ImageWithText(
            image = R.drawable.ic_cloudy,
            text = "どんよりとした雲",
            height = 24.dp,
            style = Texts.Style.BODY
        )
        Texts.Header(text = "-3℃")
        Texts.Description(text = "最高 4℃ / 最低 -5℃")
        Texts.Description(text = "1013 hPa 69%")
        ImageWithText(
            image = R.drawable.ic_wind_soutuheast,
            text = "南西 0.5 m/s",
            height = 16.dp,
            style = Texts.Style.DESCRIPTION
        )
    }
}

@Composable
fun ImageWithText(
    image: Int,
    text: String,
    height: Dp,
    style: Texts.Style
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(4.dp)
            .size(100.dp, 16.dp)
    ) {
        Image(
            painterResource(image),
            "cloudy",
            Modifier.fillMaxHeight()
        )
        Texts.Build(
            text = text,
            style = style
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        WeatherCard("青森市")
    }
}
