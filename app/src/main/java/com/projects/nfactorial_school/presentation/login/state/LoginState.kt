package com.projects.nfactorial_school.presentation.login.state

import android.os.Message

data class LoginState(
    val login: String ,
    val password: String ,
    val isLoading: Boolean ,
    val token: String?,
    val errorMessage: String?
)
