package com.projects.nfactorial_school.presentation.catalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import com.projects.nfactorial_school.data.token.TokenProvider
import com.projects.nfactorial_school.presentation.catalog.state.CatalogState
import com.projects.nfactorial_school.presentation.catalog.view.CatalogScreen
import com.projects.nfactorial_school.presentation.catalog.viewmodel.CatalogViewModel
import com.projects.nfactorial_school.ui.theme.NFactorialSchoolTheme
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CatalogActivity : ComponentActivity() {
    private val tokenProvider: TokenProvider by inject()
    private val viewModel: CatalogViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            NFactorialSchoolTheme {
                val state = viewModel.state.collectAsState().value
                CatalogScreen(
                    state = state,
                    tokenProvider,
                    onEvent = { event -> viewModel.dispatch(event) }
                )
            }
        }
    }
}