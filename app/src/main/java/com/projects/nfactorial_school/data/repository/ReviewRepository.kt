package com.projects.nfactorial_school.data.repository

import android.util.Log
import com.projects.nfactorial_school.data.api.Api
import com.projects.nfactorial_school.data.model.ReviewResponse

class ReviewRepository(
    private val authorizedApi : Api
) {
    suspend fun getReview() : ReviewResponse{
        val response = authorizedApi.getReview()
        Log.d("ReviewResponse", " Received reviews: ${response.reviews?.size}")
        return response
    }
}