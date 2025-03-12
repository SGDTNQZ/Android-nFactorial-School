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
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val authRepository: AuthRepository,
    private val errorHandler: ErrorHandler
) : ViewModel() {

    private val _state = MutableStateFlow(RegistrationState())
    val state: StateFlow<RegistrationState> = _state

    private val _effect = MutableSharedFlow<RegistrationEffect>()



    fun dispatch(event: RegistrationEvent) {
        when (event) {
            is RegistrationEvent.OnLoginChange -> {
                _state.value = _state.value.copy(login = event.login)
            }
            is RegistrationEvent.OnPasswordChange -> {
                _state.value = _state.value.copy(password = event.password)
            }
            is RegistrationEvent.OnRegisterClicked -> {
                register()
            }
        }
    }

    private fun register() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, errorMessage = null)
            try {
                val response = authRepository.register(
                    login = _state.value.login,
                    password = _state.value.password
                )
                _state.value = _state.value.copy(token = response.token, isLoading = false)
                _effect.emit(RegistrationEffect.NavigateToHome)
            } catch (e: Exception) {
                val errorMessage = errorHandler.handle(e)
                _state.value = _state.value.copy(
                    isLoading = false,
                    errorMessage = errorMessage
                )
            }
        }
    }
}
