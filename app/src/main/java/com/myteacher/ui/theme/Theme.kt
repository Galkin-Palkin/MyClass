package com.myteacher.ui.theme

import android.widget.ToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Immutable
data class ThemeColors(
    val surface: Color,
    val primary: Color,
    val primaryText: Color,
    val header: Color,
    val border: Color,
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val onPrimary: Color,
    val toggleButtonBackground: Color,
    val blockedToggleButtonBackground: Color,
    val inputFieldBackground: Color,
)

@Immutable
data class ThemeTypography(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val default: TextStyle,
    val button: TextStyle,
    val menuText: TextStyle,
    val selectedMenuText: TextStyle,
    val inputFieldInnerText: TextStyle,
    val inputFieldHeader: TextStyle,
    val dropDownMenuText: TextStyle,
)

@Immutable
data class CustomElevation(
    val default: Dp,
    val pressed: Dp
)

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
        blockedToggleButtonBackground = BlockedToggleButtonBackgroundColor,
        inputFieldBackground = Color.Unspecified,
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

val LocalCustomElevation = staticCompositionLocalOf {
    CustomElevation(
        default = Dp.Unspecified,
        pressed = Dp.Unspecified
    )
}

@Composable
fun CustomTheme(

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
    )

    val themeTypography = ThemeTypography(
        h1 = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.Bold),
        h2 = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold),
        h3 = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
        h4 = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
        default = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
        button = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
        menuText = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
        selectedMenuText = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.Black),
        inputFieldInnerText = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
        inputFieldHeader = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
        dropDownMenuText = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        ),
    )

    val customElevation = CustomElevation(
        default = 4.dp,
        pressed = 8.dp
    )

    CompositionLocalProvider(
        LocalThemeColors provides themeColors,
        LocalThemeTypography provides themeTypography,
        LocalCustomElevation provides customElevation,
        content = content
    )
}

object CustomTheme {
    val colors: ThemeColors
        @Composable
        get() = LocalThemeColors.current
    val typography: ThemeTypography
        @Composable
        get() = LocalThemeTypography.current
    val elevation: CustomElevation
        @Composable
        get() = LocalCustomElevation.current
}