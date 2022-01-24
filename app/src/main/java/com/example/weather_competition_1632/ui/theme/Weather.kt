package com.example.weather_competition_1632.ui.theme

import com.example.weather_competition_1632.R

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

    fun image(): Int {
        return when (this) {
            SUNNY -> R.drawable.ic_sunny
            CLOUDY -> R.drawable.ic_cloudy
            RAINY -> R.drawable.ic_rainy
            SNOWY -> R.drawable.ic_snowy
            STORMY -> R.drawable.ic_heavy_rainy
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
                "${(-10..20).random()}℃"
            )
        }
    }
}

data class WeekDayForecast(
    val day: String,
    val weather: Weather,
    val maxTemperature: Int,
    val minTemperature: Int
) {
    /**
     * デモのためランダムの天気を生成する
     */
    companion object {

        fun getRandom(date: Int): WeekDayForecast {
            return WeekDayForecast(
                date.toString(),
                Weather.random(),
                (-10..20).random(),
                (-10..20).random()
            )
        }
    }
}
