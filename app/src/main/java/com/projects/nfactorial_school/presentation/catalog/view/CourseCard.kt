package com.projects.nfactorial_school.presentation.catalog.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.projects.nfactorial_school.ui.theme.AppTheme


@Composable
fun CourseCard(
    imgUrl: String,
    name: String,
    price: Int,
    tags: List<String>,
    duration: String,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .width(174.dp)
            .height(210.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(10.dp)
    ) {
        Box {
            AsyncImage(
                model = imgUrl,
                contentDescription = "Course Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black)
                        )
                    )
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 14.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = name,
                    style = AppTheme.fonts.bodyTypography.bodyRegular,
                    color = AppTheme.colors.textColors.white,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    InfoCircles(price.toString())
                    InfoCircles(duration)
                }


                Row(
                    modifier = Modifier.padding( bottom = 14.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    tags.forEach { tag ->
                        InfoCircles(tag)
                    }
                }
            }
        }
    }
}
@Composable
fun InfoCircles(text: String) {
    Box(
        modifier = Modifier
            .padding(top = 4.dp, end = 4.dp)
            .border(1.dp, AppTheme.colors.brandColors.white, CircleShape)
            .padding(horizontal = 8.dp, vertical = 5.dp)
    ) {
        Text(
            text = text,
            style = AppTheme.fonts.captionTypography.captionSmall,
            color = AppTheme.colors.textColors.white,
        )
    }
}