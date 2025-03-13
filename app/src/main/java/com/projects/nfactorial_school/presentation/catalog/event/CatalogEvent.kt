package com.projects.nfactorial_school.presentation.catalog.event

sealed class CatalogEvent {
    object OnLoadData : CatalogEvent()
    data class OnFilterSelected(val filter: String?) : CatalogEvent()
    object OnApplyClicked : CatalogEvent()
    object OnCourseSelected : CatalogEvent()
}