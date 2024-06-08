package com.example.jetbizcard.ui.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbizcard.R
import com.example.jetbizcard.ui.theme.JetBizCardTheme
import com.example.jetbizcard.ui.theme.Purple40

@Composable
fun CreateBizCard(personName: String = "", onclickListener: () -> Unit = {}) {
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 16.dp)
                    .weight(1F),
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = "profile image",
            )
            Divider(color = Color.LightGray, thickness = 1.dp)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp, vertical = 10.dp)
                    .weight(4F),
            ) {
                Text(text = personName, fontSize = 24.sp, color = Purple40)
                Text(
                    text = "Android Compose Programmer",
                    modifier = Modifier.padding(vertical = 5.dp)
                )
                Text(text = "@themilesCompose")
                Button(
                    onClick = { onclickListener.invoke() },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Purple40)

                ) {
                    Text(text = stringResource(id = R.string.cardButtonText))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CreateBizCardPreview() {
    JetBizCardTheme {
        CreateBizCard(personName = "Miles P.")
    }
}