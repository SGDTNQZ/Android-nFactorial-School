package com.projects.nfactorial_school

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.projects.nfactorial_school.ui.theme.*


class TestActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloPreview()
        }
    }
}
@Composable
fun Hello(){
    Column {
        Row {
            Text(
                text = "Hello world!",
                style = AppTheme.fonts.titleMedium,
                color = AppTheme.colors.text.primary
            )
        }
        Row {
            Text(
                text = "Hello world!",
                style = AppTheme.fonts.headlineMedium,
                color = AppTheme.colors.text.secondary,
                modifier = Modifier.background(
                    color = Color.LightGray
                )
            )
        }
        Row {
            Text(
                text = "Hello world!",
                style = AppTheme.fonts.bodyMedium,
                color = AppTheme.colors.text.search,
            )
        }
        Row {
            Text(
                text = "Hello world!",
                style = AppTheme.fonts.labelMedium,
                color = AppTheme.colors.brand.primary
            )
        }
        Row {
            Text(
                text = "Hello world!",
                style = AppTheme.fonts.labelSmall,
                color = AppTheme.colors.link.primary
            )
        }
        Row {
            Text(
                text = "Hello world!",
                style = AppTheme.fonts.labelSmall,
                color = AppTheme.colors.link.activated
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun HelloPreview(){
    Hello()
}
