package com.projects.nfactorial_school.presentation.splash.event

sealed class SplashEvent {
    object OnCheckToken : SplashEvent()
    object OnRetry : SplashEvent()
}
