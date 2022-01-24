package com.example.weather_competition_1632

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.weather_competition_1632.ui.theme.*


@Composable
fun WeatherCard(
    weather: WeatherBusinessModel
) {
    Card(
        border = BorderStroke(0.dp, Color.Transparent),
        backgroundColor = Color(0x66ffffff),
        elevation = 4.dp,
        modifier = Modifier.border(0.dp, Color.Transparent)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Texts.Body(text = weather.location)
            ImageWithText(
                image = weather.weather.image(),
                text = weather.weather.description(),
                height = 24.dp,
                style = Texts.Style.BODY
            )
            Texts.Header(text = "${weather.temperature} ℃")
            Texts.Description(text = "最高 ${weather.maxTemp}℃ / 最低 ${weather.minTemp}℃")
            Texts.Description(text = "${weather.pressure} hPa ${weather.humidity}%")
            ImageWithText(
                image = R.drawable.ic_wind_soutuheast,
                text = "${weather.windDirection} ${weather.windSpeed} m/s",
                height = 16.dp,
                style = Texts.Style.DESCRIPTION
            )
        }
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
fun OneDayForecast(
    forecast: List<OneHourForecast>
) {

    LazyRow(
        modifier = Modifier.border(1.dp, Color.Black)
    ) {
        items(forecast) { forecast ->
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

@Composable
fun WeeklyForecast(
    forecast: List<WeekDayForecast>
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Black)
    ) {
        items(forecast) { forecast ->
            WeekdayForecastCell(forecast = forecast)
        }
    }
}

@Composable
fun WeekdayForecastCell(
    forecast: WeekDayForecast
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Texts.Description(text = "${forecast.day}日")
        Image(
            painter = painterResource(id = forecast.weather.image()),
            contentDescription = "",
            modifier = Modifier.fillMaxHeight()
        )
        Texts.Description(text = "最高 ${forecast.maxTemperature}℃ / 最低 ${forecast.minTemperature}℃")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        WeatherCard(WeatherBusinessModel.mock())
    }
}

@Preview(showBackground = true)
@Composable
fun OneDayForecastPreview() {
    AppTheme {
        OneDayForecast(WeatherBusinessModel.mock().oneDayForecast)
    }
}

@Preview(showBackground = true)
@Composable
fun WeeklyForecastPreview() {
    AppTheme {
        WeeklyForecast(WeatherBusinessModel.mock().weeklyForecast)
    }
}
