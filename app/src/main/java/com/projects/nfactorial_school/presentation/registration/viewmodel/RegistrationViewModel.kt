package com.projects.nfactorial_school.presentation.registration.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.nfactorial_school.data.repository.AuthRepository
import com.projects.nfactorial_school.domain.util.ErrorHandler
import com.projects.nfactorial_school.presentation.registration.effect.RegistrationEffect
import com.projects.nfactorial_school.presentation.registration.event.RegistrationEvent
import com.projects.nfactorial_school.presentation.registration.state.RegistrationState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val authRepository: AuthRepository,
    private val errorHandler: ErrorHandler
) : ViewModel() {

    private val _state = MutableStateFlow(RegistrationState())
    val state: StateFlow<RegistrationState> = _state

    private val _effect = MutableSharedFlow<RegistrationEffect>()
    val effect = _effect.asSharedFlow()

    fun dispatch(event: RegistrationEvent) {
        when (event) {
            is RegistrationEvent.OnLoginChange -> {
                _state.update { it.copy(login = event.login) }
            }
            is RegistrationEvent.OnPasswordChange -> {
                _state.update { it.copy(password = event.password) }
            }
            is RegistrationEvent.OnRegisterClicked -> {
                register()
            }
        }
    }

    private fun register() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, errorMessage = null) }
            try {
                val response = authRepository.register(
                    login = _state.value.login,
                    password = _state.value.password
                )
                _state.update { it.copy(token = response.token, isLoading = false) }
                _effect.emit(RegistrationEffect.NavigateToMain)
            } catch (e: Exception) {
                val errorMsg = errorHandler.handle(e)
                _state.update { it.copy(isLoading = false, errorMessage = errorMsg) }
                _effect.emit(RegistrationEffect.ShowError(errorMsg))
            }
        }
    }
}
