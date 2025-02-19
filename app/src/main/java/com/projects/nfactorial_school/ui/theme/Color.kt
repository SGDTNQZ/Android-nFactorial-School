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
    val text : TextColor,
    val link : LinkColor,
    val brand : BrandColor
)

data class TextColor(
    val primary : Color,
    val secondary : Color,
    val search : Color
)

data class LinkColor(
    val primary: Color,
    val activated : Color
)

data class BrandColor(
    val primary: Color,
    val secondary: Color
)

val appColors = Colors(
    text = TextColor(
        primary = Color(0xFF1F1F1F),
        secondary = Color(0xFFF6F6F6),
        search = Color(0xFFB2B2B2)
    ),
    link = LinkColor(
        primary = Color(0xFF16A1ED),
        activated = Color(0xFF6650a4),
    ),
    brand = BrandColor(
        primary = Color(0xFFDF1323),
        secondary = Color(0xFFF6F6F6),
        )
)

internal val LocalColors = staticCompositionLocalOf { appColors }