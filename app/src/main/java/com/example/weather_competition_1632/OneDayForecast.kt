package com.example.weather_competition_1632

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather_competition_1632.ui.theme.AppTheme
import com.example.weather_competition_1632.ui.theme.OneHourForecast
import com.example.weather_competition_1632.ui.theme.Texts

@Composable
fun OneDayForecast(
    forecast: List<OneHourForecast>,
) {
    val borderWidth = dimensionResource(id = R.dimen.border_width_xs)

    LazyRow(
        modifier = Modifier.border(borderWidth, Color.Black).background(Color((0xaaeeeeee)))
    ) {
        items(forecast) { forecast ->
            OneHourForecastCell(forecast = forecast)
        }
    }
}

@Composable
fun OneHourForecastCell(
    forecast: OneHourForecast,
) {
    val cellWidth = dimensionResource(id = R.dimen.oneday_forecast_cell_width)
    val cellHeight = dimensionResource(id = R.dimen.oneday_forecast_cell_height)
    val cellPadding = dimensionResource(id = R.dimen.oneday_forecast_cell_padding)
    val imagePadding = dimensionResource(id = R.dimen.oneday_forecast_cell_image_padding)

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(cellWidth, cellHeight)
            .padding(cellPadding)
    ) {
        Texts.Description(text = forecast.time)
        Image(
            painter = painterResource(id = forecast.weather.image()),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(imagePadding)
        )
        Texts.Description(text = forecast.temperature)
    }
}

@Preview(showBackground = true)
@Composable
fun OneDayForecastPreview() {
    AppTheme {
        OneDayForecast(WeatherBusinessModel.mock().oneDayForecast)
    }
}
