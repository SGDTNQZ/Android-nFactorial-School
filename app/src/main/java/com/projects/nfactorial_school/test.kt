package com.projects.nfactorial_school

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                style = MaterialTheme.typography.titleMedium,
                color = Primary
            )
        }
        Row {
            Text(
                text = "Hello world!",
                style = MaterialTheme.typography.headlineMedium,
                color = Text
            )
        }
        Row {
            Text(
                text = "Hello world!",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Row {
            Text(
                text = "Hello world!",
                style = MaterialTheme.typography.labelMedium,
                color = Link
            )
        }
        Row {
            Text(
                text = "Hello world!",
                style = MaterialTheme.typography.labelSmall,
                color = DarkGray_900
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun HelloPreview(){
    Hello()
}
