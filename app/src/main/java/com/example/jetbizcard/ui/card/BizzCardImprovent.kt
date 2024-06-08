package com.example.jetbizcard.ui.card

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.R
import com.example.jetbizcard.domain.ProjectUIModel
import com.example.jetbizcard.ui.theme.Purple40


@Composable
fun BizzCardImprove(
    personName: String = "",
    projectList: List<ProjectUIModel> = emptyList(),
    context: Context
) {
    var isListVisible by remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CreateImageProfile()
                Divider(color = Color.LightGray, thickness = 2.dp)
                CreateContactInfo(personName = personName)
                Button(
                    onClick = {
                        isListVisible = !isListVisible
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(containerColor = Purple40)

                ) {
                    Text(text = stringResource(id = R.string.cardButtonText))
                }
                if (isListVisible) {
                    ProjectList(data = projectList, itemClickedListener = {
                        Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
    }

}


@Composable
private fun CreateContactInfo(personName: String = "") {
    Column(
        modifier = Modifier
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = personName,
            color = Purple40,
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = "Android Compose Programmer", style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "@themilesCompose", style = MaterialTheme.typography.bodyLarge
        )

    }

}

@Composable
private fun ProjectList(
    data: List<ProjectUIModel> = emptyList(),
    itemClickedListener: (ProjectUIModel) -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .padding(3.dp),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        border = BorderStroke(2.dp, Color.LightGray),
        color = Color.White,
    ) {
        LazyColumn(contentPadding = PaddingValues(10.dp)) {
            items(data) { project ->
                ProjectItem(project = project, itemClickedListener = itemClickedListener)
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProjectItem(
    project: ProjectUIModel, itemClickedListener: (ProjectUIModel) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        onClick = { itemClickedListener.invoke(project) }
    ) {

        Row(
            modifier = Modifier.padding(start = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CreateImageProfile()
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .wrapContentSize()
            ) {
                Text(
                    text = project.name,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = project.description,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }


}

@Composable
private fun CreateImageProfile() {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 2.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile image",
            modifier = Modifier.size(500.dp),
            contentScale = ContentScale.Fit
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BizzCardCoursePreview() {
    val localContext = LocalContext.current
    val projectList = listOf(
        ProjectUIModel("Compose", "Jetpack Compose", "2021"),
        ProjectUIModel("Compose", "Jetpack Compose", "2021"),
        ProjectUIModel("Compose", "Jetpack Compose", "2021"),
    )
    BizzCardImprove(
        personName = "Miles P.",
        projectList = projectList,
        context = localContext
    )
}

@Preview(showBackground = true)
@Composable
fun ProjectListPreview() {
    val projectList = listOf(
        ProjectUIModel("Compose", "Jetpack Compose", "2021"),
        ProjectUIModel("Compose", "Jetpack Compose", "2021"),
        ProjectUIModel("Compose", "Jetpack Compose", "2021"),
    )

    ProjectList(data = projectList)

}

@Preview(showBackground = true)
@Composable
fun ProjectItemPreview() {
    ProjectItem(project = ProjectUIModel("Compose", "Jetpack Compose", "2021"))
}