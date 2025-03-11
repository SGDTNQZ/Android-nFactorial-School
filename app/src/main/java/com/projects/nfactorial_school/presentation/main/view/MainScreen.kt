package com.projects.nfactorial_school.presentation.main.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projects.nfactorial_school.R
import com.projects.nfactorial_school.presentation.courses.state.CourseDescriptionCard
import com.projects.nfactorial_school.presentation.courses.state.CoursesFilter
import com.projects.nfactorial_school.presentation.courses.view.CourseCard
import com.projects.nfactorial_school.presentation.courses.view.FilterButton
import com.projects.nfactorial_school.presentation.navBar.NavBar
import com.projects.nfactorial_school.presentation.topBar.TopBar
import com.projects.nfactorial_school.ui.theme.AppTheme

@Composable
fun MainScreen(){
    val filterAll = stringResource(R.string.filter_all)

    var selectedFilter by remember {
        mutableStateOf(CoursesFilter(filterAll, filterAll))
    }

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
    )
    val filters = listOf(
        CoursesFilter(
            stringResource(R.string.filter_all),
            stringResource(R.string.filter_all),
        ),
        CoursesFilter(
            stringResource(R.string.from_scratch),
            stringResource(R.string.from_scratch),
        ),
        CoursesFilter(
            stringResource(R.string.filter_with_experience),
            stringResource(R.string.filter_with_experience),
        ),
    )

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
            CompaniesCard()
            YearsOnMarketBox()
            CommunityBox()
            CoursesHeader()
            LazyRow {
                items(filters) { item ->
                    FilterButton(
                        filter = item,
                        isSelected = (item.id == selectedFilter.id),
                        onClick = { selectedFilter = item }
                    )
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .padding(top = 14.dp,start = 4.dp, end = 4.dp)
                    .height(210.dp)

            ) {
                items(listOfCourses){
                    item ->
                    CourseCard(courseInfo = item)
                }
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
fun CompaniesCard() {
    Box(
        modifier = Modifier
            .padding(top = 51.dp)
            .fillMaxWidth()
            .padding(horizontal = 9.dp)
            .height(140.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Image(
            painter = painterResource(R.drawable.img_companies),
            contentDescription = "Companies image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun YearsOnMarketBox(){
    Row(
        modifier = Modifier
            .padding(top = 9.dp)
            .fillMaxWidth()
            .padding(horizontal = 9.dp)
            .height(140.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(
                color = AppTheme.colors.brandColors.red
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier = Modifier
                .padding(start = 18.dp)
                .size(160.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.years_on_market),
                color = AppTheme.colors.textColors.white,
                style = AppTheme.fonts.titleTypography.titleBold
            )
            Text(
                text = stringResource(R.string.year_2013),
                color = AppTheme.colors.textColors.white,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Image(
            painter = painterResource(R.drawable.ic_rocket),
            contentDescription = "Rocket",
            modifier = Modifier
                .padding(end = 50.dp, top = 17.dp, bottom = 45.dp)
                .size(78.dp)

        )

    }
}

@Composable
fun CommunityBox() {
    val colorStops = arrayOf(
        0.0f to Color(0xFF59AC3D),
        1f to Color.Transparent
    )
    Box(
        modifier = Modifier
            .padding(top = 9.dp)
            .fillMaxWidth()
            .padding(horizontal = 9.dp)
            .height(140.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Image(
            painter = painterResource(R.drawable.img_comunity),
            contentDescription = "Community image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.linearGradient(colorStops = colorStops))
        )
        Text(
            text = stringResource(R.string.community),
            style = AppTheme.fonts.titleTypography.titleBold,
            color = AppTheme.colors.textColors.white,
            modifier = Modifier
                .padding(top = 20.dp, start = 18.dp, end = 109.dp)
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
