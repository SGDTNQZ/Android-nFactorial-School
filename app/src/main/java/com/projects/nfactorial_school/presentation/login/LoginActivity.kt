package com.projects.nfactorial_school.presentation.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.projects.nfactorial_school.presentation.login.view.LoginScreen
import com.projects.nfactorial_school.ui.theme.NFactorialSchoolTheme

class LoginActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent{
            NFactorialSchoolTheme {
                LoginScreen()
            }
        }

    }
}