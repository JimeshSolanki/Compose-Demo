package com.demo.composeui.ui.generic

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.demo.composeui.ui.theme.ComposeUITheme

@Preview
@Composable
fun CheckBoxPreviewer() {
    ComposeUITheme {
        GenericCheckBox(text = "Checkbox") { }
    }
}

@Preview
@Composable
fun ButtonPreviewer() {
    ComposeUITheme {
        GenericButton(
            text = "Button",
            onClick = {}
        )
    }
}