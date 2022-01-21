package com.example.weather_competition_1632.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

object Texts {

    @Composable
    fun Header(text: String) {
        Text(
            text = text,
            style = MaterialTheme.typography.h3
        )
    }

    @Composable
    fun Body(text: String) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1
        )
    }

    @Composable
    fun Description(text: String) {
        Text(
            text = text,
            style = MaterialTheme.typography.caption
        )
    }
}
