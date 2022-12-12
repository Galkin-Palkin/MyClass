package com.myteacher.ui.primitives

import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.myteacher.ui.theme.Theme

//TODO add disabled color
@Composable
fun CustomRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    RadioButton(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = RadioButtonDefaults.colors(
            selectedColor = Theme.colors.primary,
            unselectedColor = Theme.colors.primaryText
        )
    )
}

@Composable
@Preview
fun RadioButtonPreview() {
    CustomRadioButton(selected = true, onClick = { })
}