package com.myteacher.ui.architecture

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.myteacher.ui.primitives.DatePicker
import com.myteacher.ui.theme.Theme
import java.util.*

@Composable
fun App() {
    val dateState = remember { mutableStateOf(Date()) }

    Theme {
        Column {
            DatePicker(dateState = dateState)
        }
    }
}