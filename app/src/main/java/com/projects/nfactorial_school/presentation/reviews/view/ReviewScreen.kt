package com.projects.nfactorial_school.presentation.reviews.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.projects.nfactorial_school.data.model.Review
import com.projects.nfactorial_school.data.token.TokenProvider
import com.projects.nfactorial_school.presentation.navBar.NavBar
import com.projects.nfactorial_school.presentation.reviews.event.ReviewEvent
import com.projects.nfactorial_school.presentation.reviews.state.ReviewState
import com.projects.nfactorial_school.presentation.topBar.TopBar
import com.projects.nfactorial_school.ui.theme.AppTheme

@Composable
fun ReviewScreen(
    tokenProvider: TokenProvider,
    state: ReviewState,
    onEvent: (ReviewEvent) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(tokenProvider)

        when {
            state.isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        color = AppTheme.colors.brandColors.red,
                        trackColor = AppTheme.colors.brandColors.lightGray900
                    )
                }
            }
            state.errorMessage.isNotEmpty() -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
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
                            onClick = { onEvent(ReviewEvent.OnRetry) },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = AppTheme.colors.brandColors.red,
                                contentColor = AppTheme.colors.textColors.white
                            ),
                        ) {
                            Text("Повторить")
                        }
                    }
                }
            }
            else -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.reviews) { review ->
                        FeedbackItem(review)
                    }
                }
            }
        }

        NavBar(2)
    }
}

@Composable
fun FeedbackItem(review: Review) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppTheme.colors.brandColors.white)
            .padding(16.dp)
    ) {
        Text(
            text = review.user,
            style = AppTheme.fonts.bodyTypography.bodyRegular,
            color = AppTheme.colors.textColors.primary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = review.message,
            style = AppTheme.fonts.captionTypography.captionRegular,
            color = AppTheme.colors.textColors.primary
        )
    }
}
