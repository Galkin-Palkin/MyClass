package com.myteacher.ui.primitives

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.ui.theme.Theme

@Composable
fun ThemeCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier
            .clip(Theme.shapes.default)
            .background(Theme.colors.surface),
        elevation = Theme.elevation.default,
        border = BorderStroke(1.dp, Theme.colors.border)
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            content()
        }
    }
}

@Composable
@Preview
fun ThemeCardPreview() {
    ThemeCard {

    }
}