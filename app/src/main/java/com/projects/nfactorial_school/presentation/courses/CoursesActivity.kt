package com.projects.nfactorial_school.presentation.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.projects.nfactorial_school.presentation.courses.view.CoursesScreen
import com.projects.nfactorial_school.ui.theme.NFactorialSchoolTheme

class CoursesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            NFactorialSchoolTheme {
                CoursesScreen()
            }
        }
    }
}