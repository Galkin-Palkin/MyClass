package com.myteacher.ui.theme

import ThemeTypography
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val LocalThemeColors = staticCompositionLocalOf {
    ThemeColors(
        surface = Color.White,
        primary = PrimaryColor,
        primaryText = PrimaryTextColor,
        header = Color.Black,
        border = BorderColor,
        primaryBackground = PrimaryBackgroundColor,
        secondaryBackground = SecondaryBackgroundColor,
        onPrimary = Color.White,
        toggleButtonBackground = ToggleButtonBackgroundColor,
        blockedToggleButtonBackground = BlockedToggleButtonBackgroundColor,
        inputFieldBackground = InputFieldBackgroundColor,
        bottomMenu = BottomMenuColor,
        appHeaderBackground = AppHeaderBackgroundColor
    )
}

val LocalThemeTypography = staticCompositionLocalOf {
    ThemeTypography(
        h2 = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.Bold),
        h3 = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold),
        h4 = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
        h5 = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),

        default = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryTextColor
        ),

        small = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryTextColor
        ),

        button = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        ),

        menuText = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryTextColor
        ),

        selectedMenuText = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Black,
            color = PrimaryColor
        ),

        inputFieldInnerText = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryTextColor
        ),

        inputFieldHeader = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryTextColor
        ),

        dropDownMenuText = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            color = PrimaryTextColor
        ),
    )
}

val LocalThemeElevation = staticCompositionLocalOf {
    ThemeElevation(
        default = 4.dp,
        dialog = 8.dp,
    )
}

val LocalThemeShapes = staticCompositionLocalOf {
    ThemeShapes(
        default = RoundedCornerShape(8.dp),
        button = RoundedCornerShape(8.dp),
        textField = RoundedCornerShape(16.dp),
        upperMenu = RoundedCornerShape(0.dp, 0.dp, 8.dp, 8.dp),
    )
}

@Composable
fun Theme(
    colors: ThemeColors = Theme.colors,
    typography: ThemeTypography = Theme.typography,
    elevation: ThemeElevation = Theme.elevation,
    shapes: ThemeShapes = Theme.shapes,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalThemeColors provides colors,
        LocalThemeTypography provides typography,
        LocalThemeElevation provides elevation,
        LocalThemeShapes provides shapes,
        content = content
    )
}

object Theme {
    val colors: ThemeColors
        @Composable
        get() = LocalThemeColors.current

    val typography: ThemeTypography
        @Composable
        get() = LocalThemeTypography.current

    val elevation: ThemeElevation
        @Composable
        get() = LocalThemeElevation.current

    val shapes: ThemeShapes
        @Composable
        get() = LocalThemeShapes.current
}