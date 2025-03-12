package com.projects.nfactorial_school.presentation.login.state

import android.os.Message

data class LoginState(
    val login: String  = "",
    val password: String  = "",
    val isLoading: Boolean  = false,
    val token: String? = null,
    val errorMessage: String? = null
)
