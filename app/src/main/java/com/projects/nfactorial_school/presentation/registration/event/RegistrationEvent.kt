package com.projects.nfactorial_school.presentation.registration.event

sealed class RegistrationEvent {
    data class OnLoginChange(val login: String) : RegistrationEvent()
    data class OnPasswordChange(val password: String) : RegistrationEvent()
    object OnRegisterClicked : RegistrationEvent()
}
