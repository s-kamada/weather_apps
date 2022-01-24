package com.example.weather_competition_1632

import com.example.weather_competition_1632.ui.theme.OneHourForecast
import com.example.weather_competition_1632.ui.theme.Weather
import com.example.weather_competition_1632.ui.theme.WeekDayForecast

data class WeatherBusinessModel(
    val location: String,
    val weather: Weather,
    val temperature: String,
    val maxTemp: String,
    val minTemp: String,
    val pressure: String,
    val humidity: String,
    val windDirection: String,
    val windVolume: String,
    val oneDayForecast: List<OneHourForecast>,
    val weekDayForecast: List<WeekDayForecast>
)
