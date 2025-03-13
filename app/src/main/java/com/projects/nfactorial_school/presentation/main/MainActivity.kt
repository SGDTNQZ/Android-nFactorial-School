package com.projects.nfactorial_school.presentation.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.projects.nfactorial_school.data.token.TokenProvider
import com.projects.nfactorial_school.presentation.catalog.CatalogActivity
import com.projects.nfactorial_school.presentation.main.effect.MainEffect
import com.projects.nfactorial_school.presentation.main.view.MainScreen
import com.projects.nfactorial_school.presentation.main.viewmodel.MainViewModel
import com.projects.nfactorial_school.ui.theme.NFactorialSchoolTheme
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity() {
    private val tokenProvider: TokenProvider by inject()
    private val viewModel: MainViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NFactorialSchoolTheme {
                val state = viewModel.state.collectAsState().value
                MainScreen(
                    state = state,
                    onEvent = { event -> viewModel.dispatch(event) },
                    tokenProvider
                )
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.effect.collect { effect ->
                    when (effect) {

                        is MainEffect.NavigateToAllCourses -> {
                            val intent = Intent(this@MainActivity, CatalogActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        is MainEffect.ShowError -> {
                            Toast.makeText(
                                this@MainActivity,
                                effect.message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
    }

}
