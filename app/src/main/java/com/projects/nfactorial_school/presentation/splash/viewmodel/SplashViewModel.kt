package com.projects.nfactorial_school.presentation.splash.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.nfactorial_school.data.repository.ValidateRepository
import com.projects.nfactorial_school.data.token.TokenProvider
import com.projects.nfactorial_school.domain.util.ErrorHandler
import com.projects.nfactorial_school.presentation.splash.effect.SplashEffect
import com.projects.nfactorial_school.presentation.splash.state.SplashState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SplashViewModel(
    private val tokenProvider: TokenProvider,
    private val validateRepository: ValidateRepository,
    private val errorHandler: ErrorHandler
) : ViewModel() {

    private val _state = MutableStateFlow(SplashState())
    val state: StateFlow<SplashState> = _state

    private val _effect = MutableSharedFlow<SplashEffect>()
    val effect = _effect.asSharedFlow()

    init {
        checkToken()
    }

    private fun checkToken() {
        val token = tokenProvider.getToken()
        if (token.isEmpty()) {
            viewModelScope.launch {
                _effect.emit(SplashEffect.NavigateToLogin)
            }
        } else {
            _state.value = SplashState(isLoading = true)
            viewModelScope.launch {
                try {
                    val resp = validateRepository.validateToken()
                    _effect.emit(SplashEffect.NavigateToMain)
                } catch (e: HttpException) {
                    if (e.code() == 401) {
                        tokenProvider.clearToken()
                        _effect.emit(SplashEffect.NavigateToLogin)
                    } else {
                        val msg = errorHandler.handle(e)
                        _state.value = SplashState(isLoading = false, errorMessage = msg)
                        _effect.emit(SplashEffect.ShowError(msg))
                    }
                } catch (e: Exception) {
                    val msg = errorHandler.handle(e)
                    _state.value = SplashState(isLoading = false, errorMessage = msg)
                    _effect.emit(SplashEffect.ShowError(msg))
                }
            }
        }
    }

    fun retryCheck() {
        _state.value = SplashState(isLoading = true, errorMessage = null)
        checkToken()
    }
}
