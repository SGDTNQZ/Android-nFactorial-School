package com.projects.nfactorial_school.presentation.main.event

sealed class MainEvent {
    object OnLoadData : MainEvent()
    object OnRetry : MainEvent()
    object OnApplyClicked : MainEvent()
    data class OnFilterSelected(val tags: String?) : MainEvent()
    object OnAllCoursesClicked : MainEvent()
    data class OnCourseClicked(val courseId: Int) : MainEvent()
}

