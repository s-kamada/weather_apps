package com.example.weather_competition_1632

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import com.example.weather_competition_1632.ui.theme.AppTheme
import com.example.weather_competition_1632.ui.theme.Texts
import com.example.weather_competition_1632.ui.theme.WeekDayForecast

@ExperimentalAnimationApi
@Composable
fun WeeklyForecast(
    forecast: List<WeekDayForecast>,
    isDarkTheme: Boolean
) {
    val borderWidth = dimensionResource(id = R.dimen.border_width_xs)

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .border(borderWidth, Color.Black)
    ) {
        items(forecast) { forecast ->
            WeekdayForecastCell(forecast = forecast, isDarkTheme)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun WeekdayForecastCell(
    forecast: WeekDayForecast,
    isDarkTheme: Boolean
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
                isExpanded -> WeekDayForecastExpanded(forecast = forecast, isDarkTheme)
                else -> WeekDayForecastCollapsed(forecast = forecast, isDarkTheme)
            }
        }
    }
}

@Composable
fun WeekDayForecastCollapsed(
    forecast: WeekDayForecast,
    isDarkTheme: Boolean
) {
    val cellHeight = dimensionResource(id = R.dimen.weekday_forecast_cell_height)
    val cellPadding = dimensionResource(id = R.dimen.weekday_forecast_cell_padding)
    val color = if (isDarkTheme) Color.Black else Color.White

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(cellHeight)
            .padding(cellPadding)
    ) {
        Texts.Description(
            text = stringResource(id = R.string.day, forecast.day),
            color = color
        )
        Image(
            painter = painterResource(id = forecast.weather.image(isDarkTheme)),
            contentDescription = "",
            modifier = Modifier.fillMaxHeight()
        )
        Texts.Description(
            text = stringResource(
                id = R.string.temperature_max_min,
                forecast.maxTemperature,
                forecast.minTemperature
            ),
            color = color
        )
    }
}

@Composable
fun WeekDayForecastExpanded(
    forecast: WeekDayForecast,
    isDarkTheme: Boolean
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
            Texts.Body(text = "1月 ${forecast.day}日")
            Image(
                painter = painterResource(id = forecast.weather.image(isDarkTheme)), "",
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
                text = stringResource(id = R.string.temperature_max_min, forecast.maxTemperature, forecast.minTemperature)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentsPadding)
        ) {
            Texts.Description(
                text = stringResource(id = R.string.pressure_and_humidity, forecast.pressure, forecast.humidity)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentsPadding)
        ) {
            Texts.Description(
                text = stringResource(id = R.string.wind_direction_speed, forecast.windDirection, forecast.windSpeed)
            )
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun WeeklyForecastPreview() {
    AppTheme {
        WeeklyForecast(WeatherBusinessModel.mock().weeklyForecast, true)
    }
}

@Preview(showBackground = true)
@Composable
fun WeekDatForecastCollapsedPreview() {
    AppTheme {
        WeekDayForecastCollapsed(forecast = WeatherBusinessModel.mock().weeklyForecast.first(), true)
    }
}

@Preview(showBackground = true)
@Composable
fun WeekDatForecastExpandedPreview() {
    AppTheme {
        WeekDayForecastExpanded(forecast = WeatherBusinessModel.mock().weeklyForecast.first(), true)
    }
}
