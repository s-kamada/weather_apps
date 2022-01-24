package com.example.weather_competition_1632.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.weather_competition_1632.R

// Set of Material typography styles to start with
val GeneralFont = FontFamily.Default
val DarkFontColor = Color.Black
val LightFontColor = Color.White
val DarkTypography = Typography(
    h3 = TextStyle(
        fontFamily = GeneralFont,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        letterSpacing = 0.sp,
        color = DarkFontColor
    ),
    h6 = TextStyle(
        fontFamily = GeneralFont,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp,
        color = DarkFontColor
    ),
    body1 = TextStyle(
        fontFamily = GeneralFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = DarkFontColor
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val LightTypography = Typography(
    h3 = TextStyle(
        fontFamily = GeneralFont,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        letterSpacing = 0.sp,
        color = LightFontColor
    ),
    h6 = TextStyle(
        fontFamily = GeneralFont,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp,
        color = LightFontColor
    ),
    body1 = TextStyle(
        fontFamily = GeneralFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = LightFontColor
    )
)
