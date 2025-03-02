package com.projects.nfactorial_school.presentation.navBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.projects.nfactorial_school.R
import com.projects.nfactorial_school.ui.theme.AppTheme

@Composable
fun NavBar() {
    var selected by remember { mutableIntStateOf(0) }
    val navItems = listOf(
        NavItem(
            R.string.bb_main,
            R.drawable.ic_main,
            R.drawable.ic_main,
            "Main icon"
        ),
        NavItem(
            R.string.bb_courses,
            R.drawable.ic_courses,
            R.drawable.ic_courses_active,
            "Courses icon"
        ),
        NavItem(
            R.string.bb_reviews,
            R.drawable.ic_reviews,
            R.drawable.ic_reviews_active,
            "Reviews icon"
        ),
        NavItem(
            R.string.bb_blogs,
            R.drawable.ic_blogs,
            R.drawable.ic_blogs_active,
            "Blogs icon"
        )
    )

    NavigationBar(
        containerColor = AppTheme.colors.brandColors.white,
        modifier = Modifier
            .padding(vertical = 8.dp)
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selected == index,
                onClick = {
                    selected = index
                },
                label = {
                    Text(
                        text = stringResource(item.labelRes),
                        style = AppTheme.fonts.captionTypography.captionRegular
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            if (selected == index) {
                                item.selectedIconRes
                            } else {
                                item.unselectedIconRes
                            }
                        ),
                        contentDescription = item.contentDescription,
                        modifier = Modifier
                            .size(28.dp)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedTextColor = AppTheme.colors.textColors.red,
                    unselectedTextColor = AppTheme.colors.textColors.gray900,
                    selectedIconColor = AppTheme.colors.brandColors.red,
                    unselectedIconColor = AppTheme.colors.brandColors.gray900
                )
            )
        }
    }
}

data class NavItem(
    val labelRes: Int,
    val unselectedIconRes: Int,
    val selectedIconRes: Int,
    val contentDescription: String
)
