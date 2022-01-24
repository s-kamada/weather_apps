package com.example.weather_competition_1632.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

object Texts {

    enum class Style {
        HEADER,
        BODY,
        DESCRIPTION
    }

    @Composable
    fun Build(text: String, style: Style) {
        when (style) {
            Style.HEADER -> Header(text = text)
            Style.BODY -> Body(text = text)
            Style.DESCRIPTION -> Description(text = text)
        }
    }

    @Composable
    fun Header(text: String) {
        Text(
            text = text,
            style = MaterialTheme.typography.h3,
        )
    }

    @Composable
    fun Body(text: String) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6
        )
    }

    @Composable
    fun Description(text: String) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1
        )
    }
}
