package com.example.jetbizcard.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbizcard.R
import com.example.jetbizcard.ui.theme.DarkGreenGrey
import com.example.jetbizcard.ui.theme.JetBizCardTheme


@Composable
fun Counter(counterStart: Int = 100, counterIncrement: Int = 10) {

    var moneyReducer by remember { mutableIntStateOf(counterStart) }

    var tapCounter by remember {
        mutableIntStateOf(0)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = DarkGreenGrey,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$$moneyReducer",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 35.sp
                )
            )
            CircularButton(
                counter = tapCounter,
                onButtonClick = {
                    moneyReducer += counterIncrement
                    tapCounter++
                })
        }
    }
}


@Composable
fun CircularButton(counter: Int = 0, onButtonClick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(105.dp)
            .clickable {
                onButtonClick()
            },
        shape = CircleShape,

        ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "${stringResource(id = R.string.circularButtonText)} $counter",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = DarkGreenGrey,
                )
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    JetBizCardTheme {
        Counter(100, 10)
    }
}