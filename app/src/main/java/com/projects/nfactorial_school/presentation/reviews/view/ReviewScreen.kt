package com.projects.nfactorial_school.presentation.reviews.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.projects.nfactorial_school.presentation.navBar.NavBar
import com.projects.nfactorial_school.presentation.topBar.TopBar

@Composable
fun ReviewScreen(){
    Column {
        TopBar()
        Text(
            text = "Review Screen"
        )
        NavBar(2)
    }
}