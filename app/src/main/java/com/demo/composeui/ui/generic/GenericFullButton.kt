package com.demo.composeui.ui.generic

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GenericButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        onClick = {
            onClick.invoke()
        },
        modifier = modifier
    ) {
        Text(text = text, style = MaterialTheme.typography.labelSmall)
    }
}