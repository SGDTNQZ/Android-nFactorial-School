package com.projects.nfactorial_school.presentation.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.nfactorial_school.data.repository.MainRepository
import com.projects.nfactorial_school.presentation.main.state.MainState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _state = MutableStateFlow(MainState(isLoading = true))
    val state: StateFlow<MainState> = _state

    init {
        loadMainData()
    }

    private fun loadMainData() {
        viewModelScope.launch {
            try {
                val response = mainRepository.getMainData()
                _state.value = MainState(
                    banners = response.banners,
                    courses = response.courses,
                    tags = response.tags,
                    isLoading = false
                )
            } catch (e: Exception) {
                _state.value = MainState(
                    isLoading = false,
                    errorMessage = e.message ?: "Unknown error"
                )
            }
        }
    }
}
