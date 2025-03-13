package com.projects.nfactorial_school.presentation.registration.effect

sealed class RegistrationEffect {
    object NavigateToMain : RegistrationEffect()
    data class ShowError(val message: String) : RegistrationEffect()
}