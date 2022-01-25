package com.example.weather_competition_1632.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import java.lang.reflect.Modifier

object Texts {

    enum class Style {
        HEADER,
        BODY,
        DESCRIPTION
    }

    // TODO: dark/lightのロジックをリファクタ
    @Composable
    fun Build(text: String, style: Style, color: Color = Color.Black) {
        when (style) {
            Style.HEADER -> Header(text = text, color = color)
            Style.BODY -> Body(text = text, color = color)
            Style.DESCRIPTION -> Description(text = text, color = color)
        }
    }

    @Composable
    fun Header(text: String, color: Color = Color.Black) {
        Text(
            text = text,
            style = MaterialTheme.typography.h3,
            color = color
        )
    }

    @Composable
    fun Body(text: String, color: Color = Color.Black) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6,
            color = color
        )
    }

    @Composable
    fun Description(text: String, color: Color = Color.Black) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            color = color
        )
    }
}
