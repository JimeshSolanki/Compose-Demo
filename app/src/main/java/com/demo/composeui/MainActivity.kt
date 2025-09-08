package com.demo.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.demo.composeui.ui.theme.ComposeUITheme
import com.demo.composeui.ui.view.Login

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeUITheme {
                ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun Counter() {
    var count by remember { mutableIntStateOf(0) }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (text, button) = createRefs()

        Text(
            text = count.toString(),
            modifier = Modifier
                //.fillMaxWidth()
                .constrainAs(text) {
                    top.linkTo(parent.top, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
        )
        Button(
            onClick = {
                count++
            }, modifier = Modifier
                //.fillMaxSize()
                .constrainAs(button) {
                    top.linkTo(text.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
            Text("Increase Counter")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CounterPreview() {
    ComposeUITheme {
        Login()
    }
}