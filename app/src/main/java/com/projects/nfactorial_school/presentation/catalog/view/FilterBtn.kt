package com.projects.nfactorial_school.presentation.catalog.view

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
import com.projects.nfactorial_school.presentation.catalog.state.CatalogFilter
import com.projects.nfactorial_school.ui.theme.AppTheme

@Composable
fun FilterButton(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    if (isSelected) {
        Button(
            onClick = onClick,
            modifier = Modifier.padding(end = 4.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = AppTheme.colors.brandColors.red,
                contentColor = AppTheme.colors.textColors.white
            )
        ) {
            Text(title, fontWeight = FontWeight.Bold)
        }
    } else {
        OutlinedButton(
            onClick = onClick,
            modifier = Modifier.padding(end = 4.dp),
            shape = CircleShape,
            border = BorderStroke(1.dp, AppTheme.colors.brandColors.gray900),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = AppTheme.colors.brandColors.white,
                contentColor = AppTheme.colors.textColors.primary
            )
        ) {
            Text(title, fontWeight = FontWeight.Bold)
        }
    }
}

