package com.myteacher.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.theme.Theme

@Composable
fun ScreenPattern(
   content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.secondaryBackground)
            .padding(32.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = stringResource(R.string.app_name),
            style = Theme.typography.h2
        )

        Spacer(modifier = Modifier.height(64.dp))

        content()
    }
}