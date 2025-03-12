package com.projects.nfactorial_school.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.lifecycleScope
import com.projects.nfactorial_school.MainApp
import com.projects.nfactorial_school.presentation.main.view.MainScreen
import com.projects.nfactorial_school.presentation.main.viewmodel.MainViewModel
import com.projects.nfactorial_school.ui.theme.NFactorialSchoolTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by lazy {
        MainViewModel((application as MainApp).mainRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NFactorialSchoolTheme {
                val state = viewModel.state.collectAsState().value
                MainScreen(state = state)
            }
        }

        lifecycleScope.launch {
            viewModel.state.collect { state ->
            }
        }
    }
}
