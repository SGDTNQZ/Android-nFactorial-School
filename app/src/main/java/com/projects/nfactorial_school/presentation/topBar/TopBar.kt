package com.projects.nfactorial_school.presentation.topBar

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.projects.nfactorial_school.R
import com.projects.nfactorial_school.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    CenterAlignedTopAppBar(
       title = {},
        navigationIcon = {
            IconButton(
                onClick = { Log.d("nFactorial logo", "Logo was pressed")},
                modifier = Modifier
                    .padding(start = 16.dp)
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
                onClick = {Log.d("Login button", "Login button was pressed")},
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
            actionIconContentColor = AppTheme.colors.brandColors.gray900,
            )
    )
}