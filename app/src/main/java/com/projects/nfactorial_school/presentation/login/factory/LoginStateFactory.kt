package com.projects.nfactorial_school.presentation.login.factory

import com.projects.nfactorial_school.presentation.login.state.LoginState

object LoginStateFactory {

    fun createInitialState(): LoginState {
        return LoginState(
            login = "",
            password = "",
            token = null,
            isLoading = false,
            errorMessage = null
        )
    }
}
