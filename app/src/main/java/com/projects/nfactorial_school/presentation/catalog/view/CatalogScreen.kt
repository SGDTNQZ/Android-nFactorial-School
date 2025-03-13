package com.projects.nfactorial_school.presentation.catalog.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.projects.nfactorial_school.R
import com.projects.nfactorial_school.data.token.TokenProvider
import com.projects.nfactorial_school.presentation.catalog.event.CatalogEvent
import com.projects.nfactorial_school.presentation.catalog.state.CatalogState
import com.projects.nfactorial_school.presentation.navBar.NavBar
import com.projects.nfactorial_school.presentation.reviews.event.ReviewEvent
import com.projects.nfactorial_school.presentation.topBar.TopBar
import com.projects.nfactorial_school.ui.theme.AppTheme


@Composable
fun CatalogScreen(
    state : CatalogState,
    tokenProvider: TokenProvider,
    onEvent: (CatalogEvent) -> Unit
){
    when {
        state.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = AppTheme.colors.brandColors.red,
                    trackColor = AppTheme.colors.brandColors.lightGray900
                )
            }
        }
        state.errorMessage?.isNotEmpty() == true -> {
            TopBar(tokenProvider)
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Ошибка: ${state.errorMessage}",
                        style = AppTheme.fonts.bodyTypography.bodyRegular,
                        color = AppTheme.colors.textColors.primary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { onEvent(CatalogEvent.OnRetry) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppTheme.colors.brandColors.red,
                            contentColor = AppTheme.colors.textColors.white
                        ),
                    ) {
                        Text("Повторить")
                    }
                }
            }
            NavBar(1)
        }
        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = AppTheme.colors.brandColors.lightGray900
                    ),
                ) {
                TopBar(tokenProvider)
                Box (
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                    ,
                ){
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier
                            .padding(top = 14.dp,start = 4.dp, end = 4.dp)
                            .fillMaxHeight()
                    ) {
                        items(state.courses){
                                item ->
                            CourseCard(
                                item.imageUrl,
                                name = item.name,
                                price = item.price.toInt(),
                                duration = item.duration,
                                tags = item.tags
                            )
                        }
                    }
                    ApplyBtn(onEvent)
                }
                NavBar(1)
            }
        }
    }
}


@Composable
fun ApplyBtn(
    onEvent: (CatalogEvent) -> Unit
){
    Button(
        onClick = {
            onEvent(CatalogEvent.OnApplyClicked)
        },
        modifier = Modifier
            .padding(bottom = 33.dp)
            .fillMaxWidth()
            .padding(horizontal = 79.dp, vertical = 13.dp),
        colors = ButtonColors(
            containerColor = AppTheme.colors.brandColors.red,
            disabledContainerColor = AppTheme.colors.brandColors.lightGray,
            disabledContentColor = AppTheme.colors.textColors.white,
            contentColor = AppTheme.colors.textColors.white
        ),
        shape = RoundedCornerShape(10.dp),

    ) {
        Text(
            text = stringResource(R.string.btn_apply),
            style = AppTheme.fonts.bodyTypography.bodyRegular,
        )
    }

}