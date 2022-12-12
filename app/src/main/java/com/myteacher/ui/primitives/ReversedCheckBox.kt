package com.myteacher.ui.primitives

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.ui.theme.Theme

@Composable
fun ReversedCheckBox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    checkBoxModifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: @Composable () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        label()

        Spacer(modifier = Modifier.weight(1f))

        CheckBox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = checkBoxModifier,
            enabled = enabled
        )
    }
}

@Composable
@Preview
fun ReversedCheckBoxPreview() {
    ReversedCheckBox(
        checked = true,
        onCheckedChange = {},
        modifier = Modifier.fillMaxWidth().padding(20.dp, 5.dp, 10.dp, 5.dp),
        label = {
            Text(
                text = "Текст",
                style = Theme.typography.default.copy(textAlign = TextAlign.Left)
            )
        }
    )
}