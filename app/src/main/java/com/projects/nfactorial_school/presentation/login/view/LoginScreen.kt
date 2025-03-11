package com.projects.nfactorial_school.presentation.login.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.projects.nfactorial_school.R
import com.projects.nfactorial_school.presentation.login.event.LoginEvent
import com.projects.nfactorial_school.presentation.login.state.LoginState
import com.projects.nfactorial_school.presentation.topBar.TopBar
import com.projects.nfactorial_school.ui.theme.AppTheme

@Composable
fun LoginScreen(
    state: LoginState,
    onEvent: (LoginEvent) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.navigationBars.asPaddingValues())
            .background(
                color = AppTheme.colors.brandColors.lightGray900
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TopBar()
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Header()
            EtLogin(
                state.login,
                onEvent
            )
            EtPassword (
                state.password,
                onEvent
            )
            if (!state.errorMessage.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = state.errorMessage,
                    style = AppTheme.fonts.captionTypography.captionRegular,
                    color = AppTheme.colors.textColors.red,
                    modifier = Modifier.padding(horizontal = 70.dp)
                )
            }
            BtnLogin(
                onEvent = onEvent
            )
        }
        BottomLink(
            onEvent = onEvent
        )

    }
}

@Composable
fun Header(){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.tvLoginHeader),
            style = AppTheme.fonts.headerTypography.headerBold
        )
    }
}

@Composable
fun EtLogin(
    login : String,
    onEvent: (LoginEvent) -> Unit
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
    ){
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 36.dp)
                .fillMaxWidth()
                .padding(horizontal = 70.dp)
            ,
            colors = TextFieldDefaults.colors(
                focusedTextColor = AppTheme.colors.textColors.primary,
                errorContainerColor = AppTheme.colors.etColors.etErrorColor,
                focusedContainerColor = AppTheme.colors.etColors.etFillColor,
                unfocusedContainerColor = AppTheme.colors.etColors.etFillColor,
                focusedPlaceholderColor = AppTheme.colors.textColors.gray900,
                unfocusedPlaceholderColor = AppTheme.colors.textColors.gray900,
                focusedIndicatorColor = AppTheme.colors.etColors.etStrokeColor,
                unfocusedIndicatorColor = AppTheme.colors.etColors.etStrokeColor,
            ),
            shape = RoundedCornerShape(10.dp),
            value = login,
            onValueChange = {
                onEvent(LoginEvent.OnLoginChange(it))
            },
            textStyle = AppTheme.fonts.bodyTypography.bodyRegular,
            maxLines = 1,
            placeholder = {
                Text(
                    text = stringResource(R.string.etLogin_placeholder),
                    style = AppTheme.fonts.bodyTypography.bodyRegular,
                )
            }
        )
    }
}

@Composable
fun EtPassword(
    password : String,
    onEvent: (LoginEvent) -> Unit
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
    ){
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 14.dp)
                .fillMaxWidth()
                .padding(horizontal = 70.dp)
            ,
            colors = TextFieldDefaults.colors(
                focusedTextColor = AppTheme.colors.textColors.primary,
                errorContainerColor = AppTheme.colors.etColors.etErrorColor,
                focusedContainerColor = AppTheme.colors.etColors.etFillColor,
                unfocusedContainerColor = AppTheme.colors.etColors.etFillColor,
                focusedPlaceholderColor = AppTheme.colors.textColors.gray900,
                unfocusedPlaceholderColor = AppTheme.colors.textColors.gray900,
                focusedIndicatorColor = AppTheme.colors.etColors.etStrokeColor,
                unfocusedIndicatorColor = AppTheme.colors.etColors.etStrokeColor,
            ),
            shape = RoundedCornerShape(10.dp),
            value = password,
            onValueChange = {
                onEvent(LoginEvent.OnPasswordChange(it))
            },
            textStyle = AppTheme.fonts.bodyTypography.bodyRegular,
            maxLines = 1,
            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                Text(
                    text = stringResource(R.string.etPassword_placeholder),
                    style = AppTheme.fonts.bodyTypography.bodyRegular,
                )
            }
        )
    }
}

@Composable
fun BtnLogin(
    onEvent: (LoginEvent) -> Unit
){
    Button(
        modifier = Modifier
            .padding(top = 37.dp)
            .fillMaxWidth()
            .padding(horizontal = 79.dp),
        onClick = {
            onEvent(LoginEvent.OnLoginClick)
        },
        colors = ButtonColors(
            containerColor = AppTheme.colors.brandColors.red,
            contentColor = AppTheme.colors.textColors.white,
            disabledContainerColor = AppTheme.colors.brandColors.red,
            disabledContentColor = AppTheme.colors.textColors.white
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = stringResource(R.string.btnLogin),
            style = AppTheme.fonts.bodyTypography.bodyRegular
        )
    }
}
@Composable
fun BottomLink(
    onEvent: (LoginEvent) -> Unit
){
    Row (
        modifier = Modifier
            .padding(top = 162.dp, bottom = 36.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = stringResource(R.string.tvNoAccount),
            style = AppTheme.fonts.captionTypography.captionRegular,
            color = AppTheme.colors.textColors.gray900
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = stringResource(R.string.tvRegistration),
            style = AppTheme.fonts.captionTypography.captionRegular,
            color = AppTheme.colors.linkColors.red,
            modifier = Modifier.clickable {
                onEvent(LoginEvent.OnNavigateToRegistration)
            }
        )
    }
}
