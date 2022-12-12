package com.myteacher.ui.architecture

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.primitives.CheckBoxWithText
import com.myteacher.ui.theme.Theme

@Composable
fun App() {
    Theme {
        var checked by remember { mutableStateOf(false) }

        CheckBoxWithText(
            checked = checked,
            onCheckedChange = {checked = it},
            text = stringResource(R.string.user_agreement),
            checkBoxModifier = Modifier.size(40.dp)
        )
    }
}