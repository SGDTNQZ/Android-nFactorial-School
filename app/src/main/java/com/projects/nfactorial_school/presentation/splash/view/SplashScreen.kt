package com.projects.nfactorial_school.presentation.splash.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.projects.nfactorial_school.R
import com.projects.nfactorial_school.data.token.TokenProvider
import com.projects.nfactorial_school.ui.theme.AppTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onNavigate: (Boolean) -> Unit,
    tokenProvider: TokenProvider

){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.brandColors.red),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(R.drawable.ic_nfactorial_logo),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }
    LaunchedEffect(Unit) {
        delay(1000)
        val token = tokenProvider.getToken()
        val isLoggedIn = token.isNotEmpty()

        onNavigate(isLoggedIn)
    }
}