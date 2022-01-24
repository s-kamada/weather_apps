package com.example.weather_competition_1632.ui.theme

import com.example.weather_competition_1632.R
import com.example.weather_competition_1632.WeatherBusinessModel

enum class Weather {
    SUNNY,
    CLOUDY,
    RAINY,
    SNOWY,
    STORMY;

    fun description(): String {
        return when (this) {
            SUNNY -> "晴れ"
            CLOUDY -> "曇り"
            RAINY -> "雨"
            SNOWY -> "雪"
            STORMY -> "嵐"
        }
    }

    fun isDarkTheme(): Boolean {
        return when (this) {
            SUNNY, CLOUDY, SNOWY -> true
            STORMY, RAINY -> false
        }
    }

    fun image(isDark: Boolean): Int {
        return when (this) {
            SUNNY -> if (isDark) { R.drawable.ic_sunny_dark } else { R.drawable.ic_sunny_light }
            CLOUDY -> if (isDark) { R.drawable.ic_cloudy_dark } else { R.drawable.ic_cloudy_light }
            RAINY -> if (isDark) { R.drawable.ic_rainy_dark } else { R.drawable.ic_rainy_light }
            SNOWY ->  if (isDark) { R.drawable.ic_snowy_dark } else { R.drawable.ic_snowy_light }
            STORMY ->  if (isDark) { R.drawable.ic_heavy_rainy_dark } else { R.drawable.ic_stormy_light }
        }
    }

    fun background(): Int {
        return when (this) {
            SUNNY -> R.drawable.bg_sunny
            CLOUDY -> R.drawable.bg_cloudy
            RAINY -> R.drawable.bg_rainy
            SNOWY -> R.drawable.bg_snowy
            STORMY -> R.drawable.bg_stormy
        }
    }

    companion object {
        fun random(): Weather {
            return values().toList().shuffled().first()
        }
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
                "${WeatherBusinessModel.mockTemp()}℃"
            )
        }
    }
}

data class WeekDayForecast(
    val day: Int,
    val weather: Weather,
    val maxTemperature: Int,
    val minTemperature: Int,
    val pressure: Int,
    val humidity: Int,
    val windDirection: String,
    val windSpeed: Float
) {
    /**
     * デモのためランダムの天気を生成する
     */
    companion object {

        fun getRandom(date: Int): WeekDayForecast {
            return WeekDayForecast(
                date,
                Weather.random(),
                WeatherBusinessModel.mockTemp(),
                WeatherBusinessModel.mockTemp(),
                WeatherBusinessModel.mockPressure(),
                WeatherBusinessModel.mockHumidity(),
                "南西",
                0.5f
            )
        }
    }
}
