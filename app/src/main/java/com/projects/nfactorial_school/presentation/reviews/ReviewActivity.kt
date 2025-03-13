package com.projects.nfactorial_school.presentation.reviews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import com.projects.nfactorial_school.data.token.TokenProvider
import com.projects.nfactorial_school.presentation.reviews.view.ReviewScreen
import com.projects.nfactorial_school.presentation.reviews.viewmodel.ReviewViewModel
import com.projects.nfactorial_school.ui.theme.NFactorialSchoolTheme
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReviewActivity : ComponentActivity() {

    private val tokenProvider: TokenProvider by inject()
    private val viewModel: ReviewViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            NFactorialSchoolTheme {
                val state = viewModel.state.collectAsState().value
                ReviewScreen(
                    tokenProvider = tokenProvider,
                    state = state,
                    onEvent = { event -> viewModel.dispatch(event) }
                )
            }
        }
    }
}
