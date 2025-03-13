package com.projects.nfactorial_school.presentation.reviews.event

sealed class ReviewEvent {
    object OnLoadData : ReviewEvent()
    object OnRetry : ReviewEvent()
}