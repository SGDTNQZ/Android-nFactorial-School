package com.projects.nfactorial_school.presentation.login.event

sealed interface LoginEvent{
    data class OnLoginChange(val login: String) : LoginEvent
    data class OnPasswordChange(val password: String) : LoginEvent
    object OnLoginClick : LoginEvent
    object OnNavigateToRegistration : LoginEvent
}