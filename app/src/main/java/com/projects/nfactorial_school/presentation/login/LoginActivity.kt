package com.projects.nfactorial_school.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.lifecycleScope
import com.projects.nfactorial_school.MainApp
import com.projects.nfactorial_school.presentation.login.effect.LoginEffect
import com.projects.nfactorial_school.presentation.login.view.LoginScreen
import com.projects.nfactorial_school.presentation.login.viewmodel.LoginViewModel
import com.projects.nfactorial_school.presentation.main.MainActivity
import com.projects.nfactorial_school.ui.theme.NFactorialSchoolTheme
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by lazy {
        LoginViewModel((application as MainApp).authRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val token = (application as MainApp).tokenProvider.getToken()
        if(token.isNotEmpty()){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
            return
        }
        setContent{
            NFactorialSchoolTheme {
                LoginScreen(
                    state = viewModel.state.collectAsState().value,
                    onEvent = {event -> viewModel.dispatch(event)}
                )
            }
        }

        lifecycleScope.launch {
            viewModel.state.collect { state ->
                if (state.token != null) {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }

        lifecycleScope.launch {
            viewModel.effect.collect { effect ->
                when (effect) {
                    is LoginEffect.NavigateToRegistration -> {
                        startActivity(Intent(this@LoginActivity, com.projects.nfactorial_school.presentation.registration.RegistrationActivity::class.java))
                        finish()
                    } else -> {}
                }
            }
        }

    }
}