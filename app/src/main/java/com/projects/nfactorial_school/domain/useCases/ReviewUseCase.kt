package com.projects.nfactorial_school.domain.useCases

import com.projects.nfactorial_school.data.model.ReviewResponse
import com.projects.nfactorial_school.data.repository.ReviewRepository

class ReviewUseCase(
    private val reviewRepository: ReviewRepository
) {
    suspend operator fun invoke(): ReviewResponse{
        return reviewRepository.getReview()
    }
}