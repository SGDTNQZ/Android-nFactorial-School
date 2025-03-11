package com.projects.nfactorial_school.presentation.login.factory

import com.projects.nfactorial_school.presentation.login.state.LoginState

object LoginStateFactory {
    fun createInitialState(): LoginState {
        return LoginState(
            login = "",
            password = "",
            isLoading = false,
            token = null,
            errorMessage = null
        )
    }
}
