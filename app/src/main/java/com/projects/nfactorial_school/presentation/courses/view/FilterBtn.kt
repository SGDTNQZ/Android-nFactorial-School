package com.projects.nfactorial_school.presentation.courses.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.projects.nfactorial_school.presentation.courses.state.CoursesFilter
import com.projects.nfactorial_school.ui.theme.AppTheme

@Composable
fun FilterButton(
    filter: CoursesFilter,
    isSelected: Boolean,
    onClick: () -> Unit
){
    if (isSelected){
        Button(
            onClick = onClick,
            modifier = Modifier
                .padding(end = 4.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                contentColor = AppTheme.colors.textColors.white,
                containerColor = AppTheme.colors.brandColors.red
            )
        ) {
            Text(
                text = filter.title,
                style = AppTheme.fonts.captionTypography.captionRegular,
                fontWeight = FontWeight.Bold
            )
        }
    } else{
        OutlinedButton(
            onClick = onClick,
            modifier = Modifier.padding(end = 4.dp),
            shape = CircleShape,
            border = BorderStroke(1.dp,AppTheme.colors.brandColors.gray900),
            colors = ButtonDefaults.buttonColors(
                contentColor = AppTheme.colors.textColors.primary,
                containerColor = AppTheme.colors.brandColors.white
            )
        ) {
            Text(
                text = filter.title,
                style = AppTheme.fonts.captionTypography.captionRegular,
                fontWeight = FontWeight.Bold
            )
        }

    }
}
