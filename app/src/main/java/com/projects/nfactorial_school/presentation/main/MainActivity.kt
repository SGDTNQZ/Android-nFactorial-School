package com.projects.nfactorial_school.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.projects.nfactorial_school.presentation.main.view.MainScreen
import com.projects.nfactorial_school.ui.theme.NFactorialSchoolTheme

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            NFactorialSchoolTheme {
                MainScreen()
            }
        }
    }
}