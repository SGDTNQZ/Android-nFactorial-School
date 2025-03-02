package com.projects.nfactorial_school.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)



data class Colors(
    val textColors : TextColors,
    val linkColors : LinkColors,
    val brandColors : BrandColors,
    val etColors: EtColors
)

data class TextColors(
    val primary : Color,
    val white : Color,
    val gray900 : Color,
    val darkerGray900: Color,
    val red: Color
)

data class LinkColors(
    val blue: Color,
    val red : Color,
    val activated : Color
)

data class BrandColors(
    val red: Color,
    val lightGray900: Color,
    val white: Color,
    val gray900: Color,
    val lightGray: Color
)

data class EtColors(
    val etFillColor: Color,
    val etErrorColor: Color,
    val etStrokeColor: Color
)

val appColors = Colors(
    textColors = TextColors(
        primary = Color(0xFF1F1F1F),
        white = Color(0xFFFFFFFF),
        gray900 = Color(0xFFB2B2B2),
        darkerGray900 = Color(0xFFA9A9A9),
        red = Color(0xFFDF1323),

    ),
    linkColors = LinkColors(
        blue = Color(0xFF16A1ED),
        red = Color(0xFFDF1323),
        activated = Color(0xFF6650a4),
    ),
    brandColors = BrandColors(
        red = Color(0xFFDF1323),
        lightGray900 = Color(0xFFF6F6F6),
        white = Color(0xFFFFFFFF),
        gray900 = Color(0xFFB2B2B2),
        lightGray = Color(0xFFDBDBDB)
        ),
    etColors = EtColors(
        etFillColor = Color(0xFFFFFFFF),
        etErrorColor = Color(0xFFDF1323),
        etStrokeColor = Color(0xFFDBDBDB)
    )
)

internal val LocalColors = staticCompositionLocalOf { appColors }