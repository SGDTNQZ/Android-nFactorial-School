package com.projects.nfactorial_school.presentation.registration.effect

import android.os.Message

sealed class RegistrationEffect {
    object NavigateToHome : RegistrationEffect()
    data class ShowError(val message: String) : RegistrationEffect()
}