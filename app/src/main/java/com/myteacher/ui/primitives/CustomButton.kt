package com.myteacher.ui.primitives

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.ui.theme.Theme
import com.myteacher.R

//TODO add disabled color
@Composable
fun CustomButton(
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues()
) {
    Button(
        onClick = onClick,
        modifier = modifier.border(1.dp, Theme.colors.border),
        enabled = enabled,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Theme.colors.primary,
            contentColor = Theme.colors.onPrimary,
        ),
        content = content,
        shape = Theme.shapes.button,
        elevation = ButtonDefaults.elevation(
            defaultElevation = Theme.elevation.default,
            pressedElevation = Theme.elevation.default,
            focusedElevation = Theme.elevation.default,
        )
    )
}

@Composable
@Preview
fun ButtonPreview() {
    CustomButton(
        onClick = {},
        content = {
            Text(
                text = stringResource(R.string.next),
                style = Theme.typography.button.copy(textAlign = TextAlign.Center)
            )
        },
        modifier = Modifier
            .height(72.dp)
            .width(480.dp)
    )
}