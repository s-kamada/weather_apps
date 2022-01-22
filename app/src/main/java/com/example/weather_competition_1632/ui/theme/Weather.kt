package com.example.weather_competition_1632.ui.theme

import com.example.weather_competition_1632.R

enum class Weather {
    SUNNY,
    CLOUDY,
    RAINY,
    SNOWY,
    STORMY;

    fun image(): Int {
        return when (this) {
            SUNNY -> R.drawable.ic_sunny
            CLOUDY -> R.drawable.ic_cloudy
            RAINY -> R.drawable.ic_rainy
            SNOWY -> R.drawable.ic_snowy
            STORMY -> R.drawable.ic_heavy_rainy
        }
    }
}
