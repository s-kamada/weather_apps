package com.example.weather_competition_1632

import com.example.weather_competition_1632.ui.theme.OneHourForecast
import com.example.weather_competition_1632.ui.theme.Weather
import com.example.weather_competition_1632.ui.theme.WeekDayForecast

data class WeatherBusinessModel(
    val location: String,
    val weather: Weather,
    val temperature: Int,
    val maxTemp: Int,
    val minTemp: Int,
    val pressure: Int,
    val humidity: Int,
    val windDirection: String,
    val windSpeed: Float,
    val oneDayForecast: List<OneHourForecast>,
    val weekDayForecast: List<WeekDayForecast>
) {
    fun mock(): WeatherBusinessModel {
        return WeatherBusinessModel(
            location = "青森市",
            weather = Weather.random(),
            temperature = mockTemp(),
            maxTemp = mockTemp(),
            minTemp = mockTemp(),
            pressure = mockPressure(),
            humidity = mockHumidity(),
            windDirection = "南西",
            windSpeed = 0.5f,
            oneDayForecast = mockOneDayForecast(),
            weekDayForecast = mockWeeklyForecast()
        )
    }

    fun mockTemp(from: Int = -10, to: Int = 20): Int {
        return random(from, to)
    }

    fun mockPressure(from: Int = 1000, to: Int = 1020): Int {
        return random(from, to)
    }

    fun mockHumidity(from: Int = 40, to: Int = 70): Int {
        return random(from, to)
    }

    fun mockOneDayForecast(): List<OneHourForecast> {
        return (0..24).map { hour ->
            OneHourForecast.getRandom(hour)
        }
    }

    fun mockWeeklyForecast(): List<WeekDayForecast> {
        return (1..7).map { day ->
            WeekDayForecast.getRandom(day)
        }
    }

    private fun random(from: Int, to: Int): Int {
        return (from..to).random()
    }
}
