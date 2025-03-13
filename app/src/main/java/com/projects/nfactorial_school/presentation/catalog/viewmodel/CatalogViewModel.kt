package com.projects.nfactorial_school.presentation.catalog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.nfactorial_school.data.repository.MainRepository
import com.projects.nfactorial_school.domain.useCases.CatalogDataUseCase
import com.projects.nfactorial_school.presentation.catalog.state.CatalogState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.update


class CatalogViewModel(
    private val repository: MainRepository
) : ViewModel() {
    private val _state = MutableStateFlow(CatalogState(isLoading = true))
    val state: StateFlow<CatalogState> = _state

    init {
        loadCatalog()
    }

    private fun loadCatalog() {
        viewModelScope.launch {
            try {
                val response = repository.getCatalogData()
                _state.value = _state.value.copy(
                    allCourses = response.courses,
                    allTags = response.tags,
                    courses = response.courses,
                    selectedTag = null,
                    isLoading = false,
                    errorMessage = null
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "Unknown error"
                )
            }
        }
    }

    fun onTagSelected(tag: String?) {
        _state.update { old ->
            val filteredCourses = if (tag.isNullOrEmpty() || tag == "Все") {
                old.allCourses
            } else {
                old.allCourses.filter { it.tags.contains(tag) }
            }
            old.copy(
                selectedTag = tag,
                courses = filteredCourses
            )
        }
    }
}

