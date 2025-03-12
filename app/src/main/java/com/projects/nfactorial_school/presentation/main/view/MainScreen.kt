package com.projects.nfactorial_school.presentation.main.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.projects.nfactorial_school.R
import com.projects.nfactorial_school.presentation.main.state.MainState
import com.projects.nfactorial_school.presentation.navBar.NavBar
import com.projects.nfactorial_school.presentation.topBar.TopBar
import com.projects.nfactorial_school.ui.theme.AppTheme

@Composable
fun MainScreen(
    state: MainState,
){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = AppTheme.colors.brandColors.lightGray900
            )
    ) {
        TopBar()
        Column (
            Modifier
                .fillMaxSize()
                .weight(1f)
                .verticalScroll(rememberScrollState() ),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Header()
            ApplyBtn()
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(state.banners) { banner ->
                    MainCard(
                        imageUrl = banner.imageUrl,
                        title = banner.text,
                        modifier = Modifier.width(200.dp)
                    )
                }
            }
            CoursesHeader()

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .padding(top = 14.dp,start = 4.dp, end = 4.dp)
                    .height(210.dp)

            ) {

            }

            BtnAllCourses()
        }
        NavBar(0)
    }
}

@Composable
fun Header(){
    Text(
        text = stringResource(R.string.main_header),
        style = AppTheme.fonts.titleTypography.titleBold,
        color = AppTheme.colors.textColors.primary,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(top = 106.dp)
            .fillMaxWidth()
            .padding(start = 33.dp, end = 35.dp)
    )
}

@Composable
fun ApplyBtn(){
    Button(
        onClick = {
        },
        modifier = Modifier
            .padding(top = 37.dp)
            .fillMaxWidth()
            .padding(horizontal = 79.dp, vertical = 13.dp),
        colors = ButtonColors(
            containerColor = AppTheme.colors.brandColors.red,
            disabledContainerColor = AppTheme.colors.brandColors.lightGray,
            disabledContentColor = AppTheme.colors.textColors.white,
            contentColor = AppTheme.colors.textColors.white
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = stringResource(R.string.btn_apply),
            style = AppTheme.fonts.bodyTypography.bodyRegular,
        )
    }

}







@Composable
fun CoursesHeader(){
    Text(
        text = stringResource(R.string.courses_and_programs),
        style = AppTheme.fonts.titleTypography.titleBold,
        color = AppTheme.colors.textColors.primary,
        modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
            .padding(start = 27.dp)
    )
}

@Composable
fun BtnAllCourses(){
    Button(
        onClick = {},
        modifier = Modifier
            .padding(top = 14.dp)
            .fillMaxWidth()
            .padding(horizontal = 127.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.brandColors.red,
            contentColor = AppTheme.colors.textColors.white
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = stringResource(R.string.all_courses_button),
            style = AppTheme.fonts.bodyTypography.bodyRegular
        )
    }
}
