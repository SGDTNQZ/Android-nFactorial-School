package com.projects.nfactorial_school.presentation.main.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.projects.nfactorial_school.R

@Preview(showBackground = true)
@Composable
fun CardPreview()
{
    MainCard(
        R.drawable.img_comunity.toString(),
        title = ""
    )
}

@Composable
fun MainCard(
    imageUrl: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(352.dp)
            .height(140.dp)
    ) {
        Column {
            AsyncImage(
                model = imageUrl,
                contentDescription = title,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}
