package com.myteacher.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val PrimaryColor = Color(0xff44bb50)
val PrimaryBackgroundColor = Color(0xffeaeaf9)
val SecondaryBackgroundColor = Color(0xfff9f9f9)
val PrimaryTextColor = Color(0xff797979)
val BorderColor = Color(0xff9c9c9c)
val InputFieldBackgroundColor = Color(0xfff2f2f2)
val ToggleButtonBackgroundColor = Color(0xfffafafa)
val BlockedToggleButtonBackgroundColor = Color(0xffefefef)
val BottomMenuColor = Color(0xfff9f9f9)

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
    val bottomMenu: Color,
)