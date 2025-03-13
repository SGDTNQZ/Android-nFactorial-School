package com.projects.nfactorial_school.presentation.splash.effect

sealed class SplashEffect {
    object NavigateToMain : SplashEffect()
    object NavigateToLogin : SplashEffect()
    data class ShowError(val message: String) : SplashEffect()
}
