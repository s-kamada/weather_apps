package com.example.weather_competition_1632

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.weather_competition_1632.ui.theme.AppTheme
import com.example.weather_competition_1632.ui.theme.Texts
import com.example.weather_competition_1632.ui.theme.Weather

@Composable
fun WeatherCard(prefectureName: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Texts.Body(text = prefectureName)
        ImageWithText(
            image = R.drawable.ic_cloudy,
            text = "曇り",
            height = 24.dp,
            style = Texts.Style.BODY
        )
        Texts.Header(text = "-3 ℃")
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
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .size(100.dp, height)
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

@Composable
fun OneDayForecast() {
    val forecasts: List<OneHourForecast> = (0..24).map { hour ->
        OneHourForecast.getRandom(hour)
    }

    LazyRow {
        items(forecasts) { forecast ->
            OneHourForecastCell(forecast = forecast)
        }
    }
}

@Composable
fun OneHourForecastCell(
    forecast: OneHourForecast
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.size(28.dp, 60.dp)
    ) {
        Texts.Description(text = forecast.time)
        Image(
            painter = painterResource(id = forecast.weather.image()),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
        )
        Texts.Description(text = forecast.temperature)
    }
}

data class OneHourForecast(
    val time: String,
    val weather: Weather,
    val temperature: String
) {

    /**
     * デモのためランダムの天気を生成する
     */
    companion object {

        fun getRandom(time: Int): OneHourForecast {
            return OneHourForecast(
                "${time}時",
                Weather.random(),
                "${(-10..20).random()}℃"
            )
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

@Preview(showBackground = true)
@Composable
fun OneDayForecastPreview() {
    AppTheme {
        OneDayForecast()
    }
}
