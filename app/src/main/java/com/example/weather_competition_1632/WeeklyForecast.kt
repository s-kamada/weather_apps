package com.example.weather_competition_1632

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import com.example.weather_competition_1632.ui.theme.AppTheme
import com.example.weather_competition_1632.ui.theme.Texts
import com.example.weather_competition_1632.ui.theme.WeekDayForecast

@ExperimentalAnimationApi
@Composable
fun WeeklyForecast(
    forecast: List<WeekDayForecast>,
) {
    val borderWidth = dimensionResource(R.dimen.border_width_xs)

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .border(borderWidth, Color.Black)
            .background(Color(0xaaeeeeee))
    ) {
        items(forecast) { forecast ->
            WeekdayForecastCell(forecast = forecast)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun WeekdayForecastCell(
    forecast: WeekDayForecast,
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
            .clickable { isExpanded = !isExpanded }
    ) {
        // TODO: find alternative. this is experimental API
        AnimatedContent(
            targetState = isExpanded,
            transitionSpec = {
                fadeIn(animationSpec = tween(150, 150)) with
                        fadeOut(animationSpec = tween(150, 150)) using
                        SizeTransform { initialSize, targetSize ->
                            keyframes {
                                IntSize(initialSize.width, targetSize.height) at 150
                                durationMillis = 300
                            }
                        }
            }
        ) { isExpanded ->
            when {
                isExpanded -> WeekDayForecastExpanded(forecast = forecast)
                else -> WeekDayForecastCollapsed(forecast = forecast)
            }
        }
    }
}

@Composable
fun WeekDayForecastCollapsed(
    forecast: WeekDayForecast,
) {
    val cellHeight = dimensionResource(R.dimen.weekday_forecast_cell_height)
    val cellPadding = dimensionResource(R.dimen.weekday_forecast_cell_padding)

    val dayString = when (forecast.day % 10) {
        1 -> stringResource(R.string.day_st, forecast.day)
        2 -> stringResource(R.string.day_nd, forecast.day)
        3 -> stringResource(R.string.day_rd, forecast.day)
        else -> stringResource(R.string.day_th, forecast.day)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(cellHeight)
            .padding(cellPadding)
    ) {
        Texts.Description(
            text = dayString,
        )
        Image(
            painter = painterResource(forecast.weather.image()),
            contentDescription = "",
            modifier = Modifier.fillMaxHeight()
        )
        Texts.Description(
            text = stringResource(
                R.string.temperature_max_min,
                forecast.maxTemperature,
                forecast.minTemperature
            ),
        )
    }
}

@Composable
fun WeekDayForecastExpanded(
    forecast: WeekDayForecast
) {
    val iconSize = dimensionResource(id = R.dimen.weather_icon_size_l)
    val padding = dimensionResource(id = R.dimen.weekday_forecast_cell_padding)
    val contentsPadding = dimensionResource(id = R.dimen.weekday_forecast_contents_padding)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentsPadding)
        ) {
            Texts.Body(text = "Jan. ${forecast.day}")
            Image(
                painter = painterResource(id = forecast.weather.image()), "",
                modifier = Modifier.size(iconSize)
            )
            Texts.Description(text = forecast.weather.description())
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentsPadding)
        ) {
            Texts.Description(
                text = stringResource(id = R.string.temperature_max_min, forecast.maxTemperature, forecast.minTemperature),
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentsPadding)
        ) {
            Texts.Description(
                text = stringResource(id = R.string.pressure_and_humidity, forecast.pressure, forecast.humidity),
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentsPadding)
        ) {
            Texts.Description(
                text = stringResource(id = R.string.wind_direction_speed, forecast.windDirection, forecast.windSpeed),
            )
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun WeeklyForecastPreview() {
    AppTheme {
        WeeklyForecast(WeatherBusinessModel.mock().weeklyForecast)
    }
}

@Preview(showBackground = true)
@Composable
fun WeekDatForecastCollapsedPreview() {
    AppTheme {
        WeekDayForecastCollapsed(forecast = WeatherBusinessModel.mock().weeklyForecast.first())
    }
}

@Preview(showBackground = true)
@Composable
fun WeekDatForecastExpandedPreview() {
    AppTheme {
        WeekDayForecastExpanded(forecast = WeatherBusinessModel.mock().weeklyForecast.first())
    }
}
