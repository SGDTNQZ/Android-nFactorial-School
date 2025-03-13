package com.projects.nfactorial_school.presentation.catalog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.nfactorial_school.data.repository.MainRepository
import com.projects.nfactorial_school.presentation.catalog.event.CatalogEvent
import com.projects.nfactorial_school.presentation.catalog.state.CatalogState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CatalogViewModel(
    private val repository: MainRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CatalogState(isLoading = true))
    val state: StateFlow<CatalogState> = _state

    init {
        dispatch(CatalogEvent.OnLoadData)
    }

    fun dispatch(event: CatalogEvent) {
        when (event) {
            is CatalogEvent.OnLoadData -> {
                loadCatalog()
            }
            is CatalogEvent.OnFilterSelected -> {
                filterCourses(event.filter)
            }
            is CatalogEvent.OnApplyClicked -> {
            }
            is CatalogEvent.OnCourseSelected -> {
            }
        }
    }

    private fun loadCatalog() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, errorMessage = null) }
            try {
                val response = repository.getCatalogData()
                _state.update { old ->
                    old.copy(
                        allCourses = response.courses,
                        tags = response.tags,
                        courses = response.courses,
                        selectedTag = null,
                        isLoading = false,
                        errorMessage = null
                    )
                }
            } catch (e: Exception) {
                _state.update { old ->
                    old.copy(
                        isLoading = false,
                        errorMessage = e.message ?: "Unknown error"
                    )
                }
            }
        }
    }

    private fun filterCourses(tag: String?) {

    }
}
