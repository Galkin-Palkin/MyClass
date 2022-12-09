package com.myteacher.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.dp

@Immutable
data class ThemeShapes(
    val default: RoundedCornerShape,
    val button: RoundedCornerShape,
    val textField: RoundedCornerShape,
    val upperMenu: RoundedCornerShape,
)