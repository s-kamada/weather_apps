package com.example.weather_competition_1632

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.weather_competition_1632.ui.theme.*

@Composable
fun WeatherCard(
    weather: WeatherBusinessModel
) {
    val cardElevation = dimensionResource(id = R.dimen.card_contents_padding)
    val cardPadding = dimensionResource(id = R.dimen.card_padding)
    val cardContentsPadding = dimensionResource(id = R.dimen.card_contents_padding)
    val textHeight = dimensionResource(id = R.dimen.text_height_l)

    Card(
        backgroundColor = Color(0xffffffff),
        elevation = cardElevation,
        modifier = Modifier
            .padding(cardPadding)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(cardContentsPadding)
        ) {
            Texts.Body(text = weather.location)
            ImageWithText(
                image = weather.weather.image(),
                text = weather.weather.description(),
                height = textHeight,
                style = Texts.Style.BODY
            )
            Texts.Header(text = stringResource(id = R.string.temperature_celsius, weather.temperature))
            Texts.Description(text = stringResource(id = R.string.temperature_max_min, weather.maxTemp, weather.minTemp))
            Texts.Description(text = stringResource(id = R.string.pressure_and_humidity, weather.pressure, weather.humidity))
            ImageWithText(
                image = R.drawable.ic_wind_soutuheast,
                text = stringResource(id = R.string.wind_direction_speed, weather.windDirection, weather.windSpeed),
                height = textHeight,
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
    val textWidth = dimensionResource(id = R.dimen.text_width_xxl)
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .size(textWidth, height)
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
        WeatherCard(WeatherBusinessModel.mock())
    }
}
