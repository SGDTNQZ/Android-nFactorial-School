package com.projects.nfactorial_school.presentation.course

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.projects.nfactorial_school.data.token.TokenProvider
import com.projects.nfactorial_school.presentation.course.view.CourseScreen
import com.projects.nfactorial_school.ui.theme.NFactorialSchoolTheme
import org.koin.android.ext.android.inject

class CourseActivity : ComponentActivity() {
    private val tokenProvider: TokenProvider by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent{
            NFactorialSchoolTheme {
                CourseScreen(
                    tokenProvider
                )
            }
        }

    }
}