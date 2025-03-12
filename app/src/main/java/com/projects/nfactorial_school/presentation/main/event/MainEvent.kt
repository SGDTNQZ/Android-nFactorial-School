package com.projects.nfactorial_school.presentation.main.event

import com.projects.nfactorial_school.presentation.courses.state.CourseDescriptionCard
import com.projects.nfactorial_school.presentation.courses.state.CoursesFilter

sealed class MainEvent {
    object OnApplyClicked : MainEvent()
    data class OnFilterSelected(val filter: CoursesFilter) : MainEvent()
    object OnAllCoursesClicked : MainEvent()
    data class OnCourseClicked(val course: CourseDescriptionCard) : MainEvent()

}
