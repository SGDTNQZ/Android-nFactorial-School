package com.projects.nfactorial_school.presentation.course

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.projects.nfactorial_school.presentation.course.view.CourseScreen
import com.projects.nfactorial_school.ui.theme.NFactorialSchoolTheme

class CourseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent{
            NFactorialSchoolTheme {
                CourseScreen()
            }
        }

    }
}