package com.projects.nfactorial_school.presentation.course.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.projects.nfactorial_school.data.token.TokenProvider
import com.projects.nfactorial_school.presentation.navBar.NavBar
import com.projects.nfactorial_school.presentation.topBar.TopBar

@Composable
fun CourseScreen(
    tokenProvider: TokenProvider
){

    Column (
        modifier = Modifier.fillMaxSize()

    ) {
        TopBar(tokenProvider)
        Text(
            text = "Course Screen"
        )
        NavBar(1)

    }
}