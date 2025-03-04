package com.projects.nfactorial_school.presentation.courses.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.projects.nfactorial_school.R
import com.projects.nfactorial_school.presentation.courses.state.CourseDescriptionCard
import com.projects.nfactorial_school.presentation.navBar.NavBar
import com.projects.nfactorial_school.presentation.topBar.TopBar
import com.projects.nfactorial_school.ui.theme.AppTheme

@Composable
fun CoursesScreen(){
    val listOfCourses = listOf(
        CourseDescriptionCard(
            imageRes = R.drawable.img_kid,
            courseTitleEng = stringResource(R.string.nFactorialTeens),
            courseTitleRus = stringResource(R.string.course_teens_title),
            price = stringResource(R.string.course_price),
            duration = stringResource(R.string.course_duration),
            levelNeeded = stringResource(R.string.from_scratch)
        ),
        CourseDescriptionCard(
            imageRes = R.drawable.img_asian_guy,
            courseTitleEng = stringResource(R.string.nFactorialSAT),
            courseTitleRus = stringResource(R.string.course_sat_title),
            price = stringResource(R.string.course_price),
            duration = stringResource(R.string.course_duration),
            levelNeeded = stringResource(R.string.from_scratch)
        ),
        CourseDescriptionCard(
            imageRes = R.drawable.img_start,
            courseTitleEng = stringResource(R.string.nFactorialStart),
            courseTitleRus = stringResource(R.string.course_start),
            price = stringResource(R.string.course_price),
            duration = stringResource(R.string.course_duration),
            levelNeeded = stringResource(R.string.from_scratch)
        ),
        CourseDescriptionCard(
            imageRes = R.drawable.img_data_analytics,
            courseTitleEng = stringResource(R.string.nFactorialDataAnalytics),
            courseTitleRus = stringResource(R.string.course_data_analytic),
            price = stringResource(R.string.course_price),
            duration = stringResource(R.string.course_duration),
            levelNeeded = stringResource(R.string.from_scratch)
        ),
        CourseDescriptionCard(
            imageRes = R.drawable.img_start,
            courseTitleEng = stringResource(R.string.nFactorialStart),
            courseTitleRus = stringResource(R.string.course_start),
            price = stringResource(R.string.course_price),
            duration = stringResource(R.string.course_duration),
            levelNeeded = stringResource(R.string.from_scratch)
        ),
        CourseDescriptionCard(
            imageRes = R.drawable.img_data_analytics,
            courseTitleEng = stringResource(R.string.nFactorialDataAnalytics),
            courseTitleRus = stringResource(R.string.course_data_analytic),
            price = stringResource(R.string.course_price),
            duration = stringResource(R.string.course_duration),
            levelNeeded = stringResource(R.string.from_scratch)
        ),
        CourseDescriptionCard(
            imageRes = R.drawable.img_kid,
            courseTitleEng = stringResource(R.string.nFactorialTeens),
            courseTitleRus = stringResource(R.string.course_teens_title),
            price = stringResource(R.string.course_price),
            duration = stringResource(R.string.course_duration),
            levelNeeded = stringResource(R.string.from_scratch)
        ),
        CourseDescriptionCard(
            imageRes = R.drawable.img_asian_guy,
            courseTitleEng = stringResource(R.string.nFactorialSAT),
            courseTitleRus = stringResource(R.string.course_sat_title),
            price = stringResource(R.string.course_price),
            duration = stringResource(R.string.course_duration),
            levelNeeded = stringResource(R.string.from_scratch)
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = AppTheme.colors.brandColors.lightGray900
            ),

    ) {
        TopBar()
        Box (
            Modifier
                .fillMaxWidth()
                .weight(1f)
            ,
        ){

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .padding(top = 14.dp,start = 4.dp, end = 4.dp)
                    .fillMaxHeight()

            ) {
                items(listOfCourses){
                        item ->
                    CourseCard(courseInfo = item)
                }
            }


            ApplyBtn()
        }
        NavBar()
    }
}

@Composable
fun ApplyBtn(){
    Button(
        onClick = {

        },
        modifier = Modifier
            .padding(bottom = 33.dp)
            .fillMaxWidth()
            .padding(horizontal = 79.dp, vertical = 13.dp),
        colors = ButtonColors(
            containerColor = AppTheme.colors.brandColors.red,
            disabledContainerColor = AppTheme.colors.brandColors.lightGray,
            disabledContentColor = AppTheme.colors.textColors.white,
            contentColor = AppTheme.colors.textColors.white
        ),
        shape = RoundedCornerShape(10.dp),

    ) {
        Text(
            text = stringResource(R.string.btn_apply),
            style = AppTheme.fonts.bodyTypography.bodyRegular,
        )
    }

}