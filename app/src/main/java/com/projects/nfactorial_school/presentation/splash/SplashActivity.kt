package com.projects.nfactorial_school.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.projects.nfactorial_school.data.token.TokenProvider
import com.projects.nfactorial_school.presentation.login.LoginActivity
import com.projects.nfactorial_school.presentation.main.MainActivity
import com.projects.nfactorial_school.presentation.splash.effect.SplashEffect
import com.projects.nfactorial_school.presentation.splash.view.SplashScreen
import com.projects.nfactorial_school.presentation.splash.viewmodel.SplashViewModel
import com.projects.nfactorial_school.ui.theme.NFactorialSchoolTheme
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : ComponentActivity() {

    private val tokenProvider: TokenProvider by inject()
    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NFactorialSchoolTheme {
                SplashScreen(
                    onNavigate = { isLoggedIn ->
                        val target = if (isLoggedIn) {
                            MainActivity::class.java
                        }else {
                            LoginActivity::class.java
                        }
                        startActivity(Intent(this, target))
                        finish()
                    },
                    tokenProvider = tokenProvider
                )
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.effect.collect { effect ->
                    when(effect) {
                        is SplashEffect.NavigateToMain -> {
                            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                            finish()
                        }
                        is SplashEffect.NavigateToLogin -> {
                            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                            finish()
                        }
                        is SplashEffect.ShowError -> {
                            Toast.makeText(
                                this@SplashActivity,
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