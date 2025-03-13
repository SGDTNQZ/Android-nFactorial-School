package com.projects.nfactorial_school.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.lifecycleScope
import com.projects.nfactorial_school.MainApp
import com.projects.nfactorial_school.data.token.TokenProvider
import com.projects.nfactorial_school.presentation.login.effect.LoginEffect
import com.projects.nfactorial_school.presentation.login.view.LoginScreen
import com.projects.nfactorial_school.presentation.login.viewmodel.LoginViewModel
import com.projects.nfactorial_school.presentation.main.MainActivity
import com.projects.nfactorial_school.presentation.registration.RegistrationActivity
import com.projects.nfactorial_school.ui.theme.NFactorialSchoolTheme
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : ComponentActivity() {

    private val viewModel: LoginViewModel by viewModel()
    private val tokenProvider: TokenProvider by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        if (tokenProvider.getToken().isNotEmpty()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        setContent {
            NFactorialSchoolTheme {
                val state = viewModel.state.collectAsState().value
                LoginScreen(
                    state = state,
                    onEvent = { event -> viewModel.dispatch(event) },
                    tokenProvider
                )
            }
        }

        lifecycleScope.launch {
            viewModel.effect.collect { effect ->
                when (effect) {
                    is LoginEffect.NavigateToRegistration -> {
                        startActivity(Intent(this@LoginActivity, RegistrationActivity::class.java))
                        finish()
                    }
                    is LoginEffect.NavigateToHome -> {
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    }
                    is LoginEffect.ShowError -> {
                    }
                }
            }
        }
    }
}
