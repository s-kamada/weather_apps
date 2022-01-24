package com.example.weather_competition_1632

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.weather_competition_1632.ui.theme.Texts
import com.example.weather_competition_1632.ui.theme.WeekDayForecast

@Composable
fun WeeklyForecast(
    forecast: List<WeekDayForecast>
) {
    val borderWidth = dimensionResource(id = R.dimen.border_width_xs)

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .border(borderWidth, Color.Black)
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
    val cellHeight = dimensionResource(id = R.dimen.weekday_forecast_cell_height)
    val cellPadding = dimensionResource(id = R.dimen.weekday_forecast_cell_padding)

    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth().animateContentSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(cellHeight)
                .padding(cellPadding)
                .clickable { isExpanded = !isExpanded }
        ) {
            Texts.Description(text = stringResource(id = R.string.day, forecast.day))
            Image(
                painter = painterResource(id = forecast.weather.image()),
                contentDescription = "",
                modifier = Modifier.fillMaxHeight()
            )
            Texts.Description(
                text = stringResource(
                    id = R.string.temperature_max_min,
                    forecast.maxTemperature,
                    forecast.minTemperature
                )
            )
        }
    }
}
