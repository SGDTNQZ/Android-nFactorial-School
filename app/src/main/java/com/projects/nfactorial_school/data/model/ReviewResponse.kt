package com.projects.nfactorial_school.data.model

import android.os.Message

data class ReviewResponse (
    val reviews : List<Review>?
)

data class Review(
    val user: String,
    val message: String
)