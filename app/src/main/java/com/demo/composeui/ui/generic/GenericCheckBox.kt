package com.demo.composeui.ui.generic

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GenericCheckBox(
    text: String,
    modifier: Modifier = Modifier,
    isChecked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable { onCheckedChange(!isChecked) }
            .padding(horizontal = 8.dp, vertical = 5.dp)
    ) {
        Checkbox(checked = isChecked, onCheckedChange = null)
        Text(
            text = text,
            style = /* Typography.bodyMedium */ MaterialTheme.typography.labelMedium
        )
    }
}