package com.projects.nfactorial_school.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


@Composable
fun NFactorialSchoolTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTypography provides appTypography,
        LocalColors provides appColors
    ) {
        content()
    }

}

object AppTheme{
    val colors : Colors
    @Composable
    get() = LocalColors.current

    val fonts : Typography
    @Composable
    get() = LocalTypography.current
}