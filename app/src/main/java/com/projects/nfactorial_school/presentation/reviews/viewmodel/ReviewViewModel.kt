package com.projects.nfactorial_school.presentation.reviews.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.nfactorial_school.data.repository.ReviewRepository
import com.projects.nfactorial_school.presentation.reviews.event.ReviewEvent
import com.projects.nfactorial_school.presentation.reviews.state.ReviewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ReviewViewModel(
    private val reviewsRepository: ReviewRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ReviewState(isLoading = true))
    val state: StateFlow<ReviewState> = _state

    init {
        dispatch(ReviewEvent.OnLoadData)
    }

    fun dispatch(event: ReviewEvent) {
        when (event) {
            is ReviewEvent.OnLoadData -> loadReviews()
            is ReviewEvent.OnRetry -> loadReviews()
        }
    }

    private fun loadReviews() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, errorMessage = "") }
            try {
                val response = reviewsRepository.getReview()
                val safeReviews = response.reviews ?: emptyList()
                println("reviews = ${response.reviews}")
                _state.update { it.copy(
                    reviews = safeReviews,
                    isLoading = false,
                    errorMessage = ""
                ) }
            } catch (e: Exception) {
                _state.update { it.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "Unknown error"
                ) }
            }
        }
    }
}
