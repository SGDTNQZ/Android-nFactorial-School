package com.projects.nfactorial_school.presentation.main.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.projects.nfactorial_school.R
import com.projects.nfactorial_school.data.model.Banner
import com.projects.nfactorial_school.data.model.Course
import com.projects.nfactorial_school.data.token.TokenProvider
import com.projects.nfactorial_school.presentation.catalog.view.CourseCard
import com.projects.nfactorial_school.presentation.catalog.view.FilterButton
import com.projects.nfactorial_school.presentation.main.event.MainEvent
import com.projects.nfactorial_school.presentation.main.state.MainState
import com.projects.nfactorial_school.presentation.navBar.NavBar
import com.projects.nfactorial_school.presentation.reviews.event.ReviewEvent
import com.projects.nfactorial_school.presentation.topBar.TopBar
import com.projects.nfactorial_school.ui.theme.AppTheme

@Composable
fun MainScreen(
    state: MainState,
    onEvent : (MainEvent) -> Unit,
    tokenProvider: TokenProvider,

) {
    when {
        state.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = AppTheme.colors.brandColors.red,
                    trackColor = AppTheme.colors.brandColors.lightGray900
                )
            }
        }
        state.errorMessage?.isNotEmpty() == true -> {
            TopBar(tokenProvider)
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Ошибка: ${state.errorMessage}",
                        style = AppTheme.fonts.bodyTypography.bodyRegular,
                        color = AppTheme.colors.textColors.primary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { onEvent(MainEvent.OnRetry) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppTheme.colors.brandColors.red,
                            contentColor = AppTheme.colors.textColors.white
                        ),
                    ) {
                        Text("Повторить")
                    }
                }
            }
            NavBar(0)
        }
        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppTheme.colors.brandColors.lightGray900)
                    .verticalScroll(rememberScrollState())

            ) {
                TopBar(tokenProvider = tokenProvider)
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Header()
                    ApplyBtn(onEvent = onEvent)
                    Banners(state.banners)
                    CoursesHeader()
                    TagsRow(
                        tags = state.tags,
                        selectedTag = state.selectedTag,
                        onEvent = { selectedTag ->
                            onEvent(MainEvent.OnFilterSelected(selectedTag.toString()))
                        }
                    )
                    CourseCardRow(state)
                    BtnAllCourses(onEvent = onEvent)
                }
                NavBar(0)
            }
        }
    }
}

@Composable
fun CourseCardRow(
    state: MainState
){
    val randomCourses = state.courses.shuffled().take(2)
    Box (
        Modifier.fillMaxWidth()
            .padding(top = 14.dp)
    ){
        LazyRow(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(horizontal = 4.dp)
        ) {
            items(randomCourses){ item ->
                CourseCard(
                    imgUrl = item.imageUrl,
                    name = item.name,
                    duration = item.duration,
                    price = item.price.toInt(),
                    tags = item.tags
                )

            }

        }
    }
}

@Composable
fun TagsRow(
    tags: List<String>,
    selectedTag: String?,
    onEvent: (MainEvent) -> Unit
) {
    val tagsUI = listOf("Все") + tags

    Row(
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .padding(start = 27.dp),
    ) {
        tagsUI.forEach { tag ->
            val isSelected = (tag == selectedTag) || (tag == "Все" && selectedTag == null)
            FilterButton(
                title = tag,
                isSelected = isSelected,
                onClick = {
                    if (tag == "Все") onEvent(MainEvent.OnFilterSelected(null))
                    else onEvent(MainEvent.OnFilterSelected(tag))
                }
            )
        }
    }
}


@Composable
fun Banners(banners: List<Banner>) {
    LazyColumn (
        modifier = Modifier
            .padding(top = 51.dp)
            .height(436.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 4.dp)
    ) {
        items(banners) { banner ->
            MainCard(
                imageUrl = banner.imageUrl,
                title = banner.text,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun ApplyBtn(
    onEvent: (MainEvent) -> Unit
) {
    Button(
        onClick = {
            onEvent(MainEvent.OnApplyClicked)
        },
        modifier = Modifier
            .padding(top = 37.dp)
            .fillMaxWidth()
            .padding(horizontal = 79.dp, vertical = 13.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.brandColors.red,
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
fun BtnAllCourses(onEvent: (MainEvent) -> Unit) {
    Button(
        onClick = { onEvent(MainEvent.OnAllCoursesClicked) },
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



