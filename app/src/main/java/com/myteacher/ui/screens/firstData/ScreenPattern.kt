package com.myteacher.ui.screens.firstData

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myteacher.ui.theme.Theme

@Composable
fun ScreenPattern(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.secondaryBackground)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}