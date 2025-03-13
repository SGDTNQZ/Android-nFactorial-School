package com.projects.nfactorial_school.presentation.topBar

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.projects.nfactorial_school.R
import com.projects.nfactorial_school.data.token.TokenProvider
import com.projects.nfactorial_school.presentation.login.LoginActivity
import com.projects.nfactorial_school.ui.theme.AppTheme
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    tokenProvider: TokenProvider
) {
    val context = LocalContext.current
    CenterAlignedTopAppBar(
        title = {},
        navigationIcon = {
            IconButton(
                onClick = {
                    Log.d("nFactorial logo", "Logo was pressed")
                    changeLanguage(context)
                },
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_nfactorial_logo),
                    contentDescription = "nFactorial logo",
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    Log.d("Login button", "Login button was pressed")
                    logOut(tokenProvider, context)
                },
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(40.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_login),
                    contentDescription = "Log out icon",
                    modifier = Modifier.size(30.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AppTheme.colors.brandColors.white,
            actionIconContentColor = AppTheme.colors.brandColors.gray900
        )
    )
}

fun logOut(
    tokenProvider: TokenProvider,
    context: Context
) {
    tokenProvider.clearToken()
    val intent = Intent(context, LoginActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    context.startActivity(intent)
}

fun changeLanguage(context: Context) {
    val currentLocale = context.resources.configuration.locales[0]
    val newLocale = if (currentLocale.language == "ru") Locale("en") else Locale("ru")

    Locale.setDefault(newLocale)
    val config = Configuration(context.resources.configuration).apply {
        setLocale(newLocale)
    }
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
    if (context is Activity) {
        context.recreate()
    }
}
