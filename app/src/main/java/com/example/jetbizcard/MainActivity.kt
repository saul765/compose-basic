package com.example.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetbizcard.domain.toProjectUIModel
import com.example.jetbizcard.repositories.ProjectLocalDataSource
import com.example.jetbizcard.ui.card.BizzCardImprove
import com.example.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetBizCardTheme {
                BizzCardImprove(
                    personName = "Miles. P",
                    projectList = getProjects(),
                    context = this
                )
            }
        }
    }
}

private fun getProjects() =
    ProjectLocalDataSource.getProjects().map { project -> project.toProjectUIModel() }


@Preview(showBackground = true)
@Composable
fun CardPreview() {
    JetBizCardTheme {
        val context = LocalContext.current
        BizzCardImprove(personName = "Miles. P", projectList = getProjects(), context = context)
    }
}