package com.projects.nfactorial_school.presentation.login.effect

sealed interface LoginEffect {
    object NavigateToRegistration : LoginEffect
    object NavigateToHome: LoginEffect
    data class ShowError(val message: String) : LoginEffect
}