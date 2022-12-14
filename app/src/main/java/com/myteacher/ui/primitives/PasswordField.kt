package com.myteacher.ui.primitives

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.myteacher.ui.theme.Theme

@Composable
fun PasswordField(
    value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier,
    innerTextStyle: TextStyle = Theme.typography.inputFieldInnerText,
    header: String = "", headerStyle: TextStyle = Theme.typography.inputFieldHeader,
) {
    InputField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        innerTextStyle = innerTextStyle,
        header = header,
        headerStyle = headerStyle,
        visualTransformation = PasswordVisualTransformation(mask = '●')
    )
}