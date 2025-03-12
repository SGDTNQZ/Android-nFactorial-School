package com.projects.nfactorial_school.presentation.login.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.nfactorial_school.domain.useCases.LoginUseCase
import com.projects.nfactorial_school.domain.util.ErrorHandler
import com.projects.nfactorial_school.presentation.login.effect.LoginEffect
import com.projects.nfactorial_school.presentation.login.event.LoginEvent
import com.projects.nfactorial_school.presentation.login.factory.LoginStateFactory
import com.projects.nfactorial_school.presentation.login.state.LoginState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val errorHandler: ErrorHandler

) : ViewModel() {

    private val _state = MutableStateFlow(LoginStateFactory.createInitialState())
    val state: StateFlow<LoginState> = _state

    private val _effect = MutableSharedFlow<LoginEffect>()
    val effect = _effect.asSharedFlow()

    fun dispatch(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnLoginChange -> _state.value = _state.value.copy(login = event.login)
            is LoginEvent.OnPasswordChange -> _state.value = _state.value.copy(password = event.password)
            is LoginEvent.OnLoginClick -> login()
            is LoginEvent.OnNavigateToRegistration -> {
                viewModelScope.launch { _effect.emit(LoginEffect.NavigateToRegistration) }
            }
        }
    }

    private fun login() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, errorMessage = null)
            try {
                val response = loginUseCase(_state.value.login, _state.value.password)
                _state.value = _state.value.copy(token = response.token, isLoading = false)
                _effect.emit(LoginEffect.NavigateToHome)
            } catch (e: Exception) {
                val errorMessage = errorHandler.handle(e)
                _state.value = _state.value.copy(errorMessage = errorMessage)
                _effect.emit(LoginEffect.ShowError(errorMessage))
            }
        }
    }
}
