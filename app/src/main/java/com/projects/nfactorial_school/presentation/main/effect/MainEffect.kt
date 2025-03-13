package com.projects.nfactorial_school.presentation.main.effect

sealed class MainEffect {
    object NavigateToAllCourses : MainEffect()
    data class ShowError(val message: String) : MainEffect()
}