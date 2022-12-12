package com.myteacher.ui.primitives

import androidx.compose.foundation.layout.Row
import androidx.compose.material.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RadioButtonWithLabel(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: @Composable () -> Unit
) {
    Row {
        RadioButton(
            selected = selected,
            onClick = onClick,
            enabled = enabled,
            modifier = modifier
        )

        label()
    }
}