package com.projects.nfactorial_school.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


data class Typography(
    val titleTypography: TitleTypography,
    val headerTypography: HeaderTypography,
    val bodyTypography: BodyTypography,
    val captionTypography: CaptionTypography,
)
data class TitleTypography (
    val titleBold : TextStyle
)
data class HeaderTypography(
    val headerBold: TextStyle
)
data class BodyTypography(
    val bodyRegular: TextStyle
)
data class CaptionTypography(
    val captionRegular: TextStyle,
    val captionSmall: TextStyle
)

val appTypography = Typography(
    titleTypography = TitleTypography(
        titleBold =  TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            lineHeight = 26.sp,
        )
    ),
    headerTypography = HeaderTypography(
        headerBold = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 23.sp,
        )
    ),
    bodyTypography = BodyTypography(
        bodyRegular =  TextStyle(
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontSize = 16.sp,
            lineHeight = 19.sp
        )
    ),
    captionTypography = CaptionTypography(
        captionRegular = TextStyle(
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontSize = 11.sp,
            lineHeight = 13.sp
        ),
        captionSmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontSize = 8.sp,
            lineHeight = 12.sp
        )
    ) ,
)

val LocalTypography = staticCompositionLocalOf { appTypography }