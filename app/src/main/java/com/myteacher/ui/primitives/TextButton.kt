package com.myteacher.ui.primitives

import android.graphics.Paint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.myteacher.ui.theme.Theme

@Composable
fun TextButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues()
) {
    CustomButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        content = {
            Text(
                text = text,
                style = Theme.typography.button
            )
        }
    )
}