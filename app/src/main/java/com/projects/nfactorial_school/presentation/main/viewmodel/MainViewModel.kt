package com.projects.nfactorial_school.presentation.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.nfactorial_school.data.repository.MainRepository
import com.projects.nfactorial_school.presentation.main.effect.MainEffect
import com.projects.nfactorial_school.presentation.main.event.MainEvent
import com.projects.nfactorial_school.presentation.main.state.MainState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _state = MutableStateFlow(MainState(isLoading = true))
    val state: StateFlow<MainState> = _state

    private val _effect = MutableSharedFlow<MainEffect>()
    val effect = _effect.asSharedFlow()

    init {
        dispatch(MainEvent.OnLoadData)
    }

    fun dispatch(event: MainEvent) {
        when(event) {
            is MainEvent.OnLoadData -> {
                loadMainData()
            }
            is MainEvent.OnRetry -> {
                loadMainData()
            }
            is MainEvent.OnApplyClicked -> {
                viewModelScope.launch {
                    _effect.emit(MainEffect.NavigateToAllCourses)
                }
            }
            is MainEvent.OnFilterSelected -> {
                filterCourses(event.tags)
            }
            is MainEvent.OnAllCoursesClicked -> {
                viewModelScope.launch {
                    _effect.emit(MainEffect.NavigateToAllCourses)
                }
            }
            is MainEvent.OnCourseClicked -> {
            }
        }
    }

    private fun filterCourses(selectedTag: String?) {
        val newCourses = if (selectedTag.isNullOrEmpty()) {
            _state.value.allCourses
        } else {
            _state.value.allCourses.filter { course ->
                course.tags.contains(selectedTag)
            }
        }
        _state.value = _state.value.copy(
            selectedTag = selectedTag,
            courses = newCourses
        )
    }

    private fun loadMainData() {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                isLoading = true,
                errorMessage = null
            )
            try {
                val response = mainRepository.getMainData()
                _state.value = _state.value.copy(
                    banners = response.banners,
                    courses = response.courses,
                    allCourses = response.courses,
                    tags = response.tags,
                    isLoading = false,
                    selectedTag = null
                )
            }  catch (e: Exception) {
                val errMsg = e.message ?: "Unknown error"
                _state.value = _state.value.copy(
                    isLoading = false,
                    errorMessage = errMsg
                )
                _effect.emit(MainEffect.ShowError(errMsg))
            }
        }
    }
}
