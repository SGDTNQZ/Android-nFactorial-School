package com.projects.nfactorial_school.presentation.main.state

import com.projects.nfactorial_school.data.model.Banner
import com.projects.nfactorial_school.data.model.Course

data class MainState(
    val banners: List<Banner> = emptyList(),
    val courses: List<Course> = emptyList(),
    val allCourses: List<Course> = emptyList(),
    val tags: List<String> = emptyList(),
    val selectedTag: String? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
