package com.myteacher.data.model.humanInfo

import androidx.compose.runtime.MutableState

data class Contact(
    val type: String,
    val value: MutableState<String>
)
