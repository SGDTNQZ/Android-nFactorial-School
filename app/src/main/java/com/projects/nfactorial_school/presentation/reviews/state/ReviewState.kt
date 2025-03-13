package com.projects.nfactorial_school.presentation.reviews.state

import android.os.Message
import com.projects.nfactorial_school.data.model.Review

data class ReviewState(
    val reviews: List<Review> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)
