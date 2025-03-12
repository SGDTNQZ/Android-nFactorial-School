package com.projects.nfactorial_school.presentation.main.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.projects.nfactorial_school.ui.theme.AppTheme

@Composable
fun MainCard(
    imageUrl: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .width(150.dp)
            .height(100.dp)
    ) {
        Column {
            AsyncImage(
                model = imageUrl,
                contentDescription = title,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = title,
                style = AppTheme.fonts.bodyTypography.bodyRegular,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
