package com.projects.nfactorial_school.presentation.catalog.state

data class CourseDescriptionCard(
    val imageRes: Int,
    val courseTitleEng: String,
    val courseTitleRus: String,
    val price: String,
    val duration: String,
    val levelNeeded: String
)
