package com.myteacher.ui.theme

import ThemeTypography
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val LocalThemeColors = staticCompositionLocalOf {
    ThemeColors(
        surface = Color.Unspecified,
        primary = Color.Unspecified,
        primaryText = Color.Unspecified,
        header = Color.Unspecified,
        border = Color.Unspecified,
        primaryBackground = Color.Unspecified,
        secondaryBackground = Color.Unspecified,
        onPrimary = Color.Unspecified,
        toggleButtonBackground = Color.Unspecified,
        blockedToggleButtonBackground = Color.Unspecified,
        inputFieldBackground = Color.Unspecified,
        bottomMenu = Color.Unspecified,
    )
}

val LocalThemeTypography = staticCompositionLocalOf {
    ThemeTypography(
        h1 = TextStyle.Default,
        h2 = TextStyle.Default,
        h3 = TextStyle.Default,
        h4 = TextStyle.Default,
        default = TextStyle.Default,
        button = TextStyle.Default,
        menuText = TextStyle.Default,
        selectedMenuText = TextStyle.Default,
        inputFieldInnerText = TextStyle.Default,
        inputFieldHeader = TextStyle.Default,
        dropDownMenuText = TextStyle.Default,
    )
}

val LocalThemeElevation = staticCompositionLocalOf {
    ThemeElevation(
        default = Dp.Unspecified,
        dialog = Dp.Unspecified
    )
}

val LocalThemeShapes = staticCompositionLocalOf {
    ThemeShapes(
        default = RoundedCornerShape(ZeroCornerSize),
        button = RoundedCornerShape(ZeroCornerSize),
        textField = RoundedCornerShape(ZeroCornerSize),
        upperMenu = RoundedCornerShape(ZeroCornerSize),
    )
}

@Composable
fun Theme(
    content: @Composable () -> Unit
) {
    val themeColors = ThemeColors(
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
        bottomMenu = BottomMenuColor
    )

    val themeTypography = ThemeTypography(
        h1 = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.Bold),
        h2 = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold),
        h3 = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
        h4 = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),

        default = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryTextColor
        ),

        button = TextStyle(
            fontSize = 28.sp,
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
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryTextColor
        ),

        inputFieldHeader = TextStyle(
            fontSize = 20.sp,
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

    val themeElevation = ThemeElevation(
        default = 4.dp,
        dialog = 8.dp
    )

    val themeShapes = ThemeShapes(
        default = RoundedCornerShape(8.dp),
        button = RoundedCornerShape(8.dp),
        textField = RoundedCornerShape(16.dp),
        upperMenu = RoundedCornerShape(0.dp, 0.dp, 8.dp, 8.dp),
    )

    CompositionLocalProvider(
        LocalThemeColors provides themeColors,
        LocalThemeTypography provides themeTypography,
        LocalThemeElevation provides themeElevation,
        LocalThemeShapes provides themeShapes,
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