package com.projects.nfactorial_school.presentation.catalog.state

import com.projects.nfactorial_school.data.model.Course

data class CatalogState(
    val allTags: List<String> = emptyList(),
    val selectedTag: String? = null,
    val courses: List<Course> = emptyList(),
    val allCourses: List<Course> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

