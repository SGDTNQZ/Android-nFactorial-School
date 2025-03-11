package com.projects.nfactorial_school.presentation.registration.state

data class RegistrationState(
    val login: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val token: String? = null
)
