package com.projects.nfactorial_school.presentation.courses.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.projects.nfactorial_school.R
import com.projects.nfactorial_school.presentation.courses.state.CourseDescriptionCard
import com.projects.nfactorial_school.ui.theme.AppTheme

@Preview(showBackground = true)
@Composable
fun CardPreview(){
    CourseCard(
        CourseDescriptionCard(
            imageRes = R.drawable.img_kid,
            courseTitleEng = stringResource(R.string.nFactorialTeens),
            courseTitleRus = stringResource(R.string.course_teens_title),
            price = stringResource(R.string.course_price),
            duration = stringResource(R.string.course_duration),
            levelNeeded = stringResource(R.string.from_scratch)
        )
    )
}
@Composable
fun CourseCard(
    courseInfo : CourseDescriptionCard
) {
    Card (
        modifier = Modifier
            .width(174.dp)
            .height(210.dp)
            .clickable {  },
        shape = RoundedCornerShape(10.dp)
    ){
        Box {
            Image(
                painter = painterResource(courseInfo.imageRes),
                contentDescription = "background image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black)
                        )
                    )
            )
            Column(
                modifier = Modifier
                    .padding(start = 14.dp, bottom = 14.dp, end = 36.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = courseInfo.courseTitleEng,
                    style = AppTheme.fonts.captionTypography.captionRegular,
                    color = AppTheme.colors.textColors.white
                )
                Text(
                    text = courseInfo.courseTitleRus,
                    style = AppTheme.fonts.bodyTypography.bodyRegular,
                    color = AppTheme.colors.textColors.white,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 4.dp)
                        .fillMaxWidth()
                )
                Row {
                    InfoCircles(courseInfo.price)
                    InfoCircles(courseInfo.duration)
                }
                InfoCircles(courseInfo.levelNeeded)

            }
        }
    }
}

@Composable
fun InfoCircles(
    text: String
){
    Box(
        modifier = Modifier
            .padding(top = 4.dp, end = 4.dp)
            .border(1.dp, AppTheme.colors.brandColors.white, CircleShape)
            .padding(horizontal = 8.dp, vertical = 5.dp),


    ){
        Text(
            text = text,
            style = AppTheme.fonts.captionTypography.captionSmall,
            color = AppTheme.colors.textColors.white,
        )    }
}