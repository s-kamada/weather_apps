package com.example.weather_competition_1632

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.weather_competition_1632.ui.theme.*


@Composable
fun WeatherCard(
    weather: WeatherBusinessModel
) {
    Card(
        backgroundColor = Color(0x66ffffff),
        elevation = 4.dp,
        modifier = Modifier
            .border(0.dp, Color.Transparent)
            .padding(80.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Texts.Body(text = weather.location)
            ImageWithText(
                image = weather.weather.image(),
                text = weather.weather.description(),
                height = 24.dp,
                style = Texts.Style.BODY
            )
            Texts.Header(text = stringResource(id = R.string.temperature_celsius, weather.temperature))
            Texts.Description(text = stringResource(id = R.string.temperature_max_min, weather.maxTemp, weather.minTemp))
            Texts.Description(text = stringResource(id = R.string.pressure_and_humidity, weather.pressure, weather.humidity))
            ImageWithText(
                image = R.drawable.ic_wind_soutuheast,
                text = stringResource(id = R.string.wind_direction_speed, weather.windDirection, weather.windSpeed),
                height = 24.dp,
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
        modifier = Modifier
            .size(52.dp, 92.dp)
            .padding(8.dp)
    ) {
        Texts.Description(text = forecast.time)
        Image(
            painter = painterResource(id = forecast.weather.image()),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
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
            .height(42.dp)
            .padding(8.dp)
    ) {
        Texts.Description(text = stringResource(id = R.string.day, forecast.day))
        Image(
            painter = painterResource(id = forecast.weather.image()),
            contentDescription = "",
            modifier = Modifier.fillMaxHeight()
        )
        Texts.Description(text = stringResource(id = R.string.temperature_max_min, forecast.maxTemperature, forecast.minTemperature))
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
