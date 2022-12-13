package com.myteacher.ui.primitives

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.myteacher.ui.theme.Theme

@Composable
fun CheckBoxWithLabel(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    checkBoxModifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: @Composable () -> Unit
) {
    Row {
        CheckBox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled,
            modifier = checkBoxModifier
        )

        label()
    }
}