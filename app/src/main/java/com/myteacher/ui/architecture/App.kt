package com.myteacher.ui.architecture

import androidx.compose.runtime.*
import com.myteacher.ui.primitives.CheckBox
import com.myteacher.ui.theme.Theme

@Composable
fun App() {
    Theme {
        var checked by remember { mutableStateOf(false) }

        CheckBox(checked = checked, onCheckedChange = {checked = it})
    }
}