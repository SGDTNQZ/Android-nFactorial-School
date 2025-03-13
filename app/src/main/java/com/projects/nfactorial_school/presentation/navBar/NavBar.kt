package com.projects.nfactorial_school.presentation.navBar

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.projects.nfactorial_school.R
import com.projects.nfactorial_school.presentation.blogs.BlogsActivity
import com.projects.nfactorial_school.presentation.catalog.CatalogActivity
import com.projects.nfactorial_school.presentation.main.MainActivity
import com.projects.nfactorial_school.presentation.reviews.ReviewActivity
import com.projects.nfactorial_school.ui.theme.AppTheme

data class NavItem(
    val labelResource : Int,
    val unselectedIconResource: Int,
    val selectedIconResource: Int,
    val contentDescription: Int,
    val targetActivity: Class<*>
)
@Composable
fun NavBar(
    currentIndex: Int
){
    val context = LocalContext.current
    val navItems = listOf(
        NavItem(
            labelResource = R.string.bb_main,
            unselectedIconResource = R.drawable.ic_main,
            selectedIconResource = R.drawable.ic_main_active,
            contentDescription = R.string.bb_main,
            targetActivity = MainActivity::class.java
        ),
        NavItem(
            labelResource = R.string.bb_courses,
            unselectedIconResource = R.drawable.ic_courses,
            selectedIconResource = R.drawable.ic_courses_active,
            contentDescription = R.string.bb_reviews,
            targetActivity = CatalogActivity::class.java
        ),
        NavItem(
            labelResource = R.string.bb_reviews,
            unselectedIconResource = R.drawable.ic_reviews,
            selectedIconResource = R.drawable.ic_reviews_active,
            contentDescription = R.string.bb_reviews,
            targetActivity = ReviewActivity::class.java
        ),
        NavItem(
            labelResource = R.string.bb_blogs,
            unselectedIconResource = R.drawable.ic_blogs,
            selectedIconResource = R.drawable.ic_blogs_active,
            contentDescription = R.string.bb_blogs,
            targetActivity = BlogsActivity::class.java
        ),
    )

    NavigationBar(
        containerColor = AppTheme.colors.brandColors.white,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        navItems.forEachIndexed{
            index, item ->
            val selected = currentIndex == index
            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected){
                        context.startActivity(Intent(context, item.targetActivity))
                        (context as Activity).finish()
                    }
                },
                label = {
                    Text(
                        text = stringResource(item.labelResource),
                        style = AppTheme.fonts.captionTypography.captionRegular
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            if (selected){
                                item.selectedIconResource
                            } else{
                              item.unselectedIconResource
                            }
                        ),
                        contentDescription = item.contentDescription.toString(),
                        modifier = Modifier.size(28.dp)
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