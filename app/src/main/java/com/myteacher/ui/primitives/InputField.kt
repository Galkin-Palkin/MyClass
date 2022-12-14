package com.myteacher.ui.primitives

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.ui.theme.Theme

@Composable
fun InputField(
    value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier,
    innerTextStyle: TextStyle = Theme.typography.inputFieldInnerText,
    header: String = "", headerStyle: TextStyle = Theme.typography.inputFieldHeader,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = innerTextStyle,
        shape = Theme.shapes.textField,
        label = {
            Text(text = header, style = headerStyle)
        },
        modifier = modifier,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Theme.colors.inputFieldBackground,
            focusedBorderColor = Theme.colors.primary,
            unfocusedBorderColor = Theme.colors.border,
            focusedLabelColor = Theme.colors.primaryText,
            unfocusedLabelColor = Theme.colors.primaryText,
            cursorColor = Theme.colors.primary
        ),
        visualTransformation = visualTransformation
    )
}

@Composable
@Preview(showBackground = true)
fun InputFieldPreview() {
    InputField(
        value = "Абракадабра",
        onValueChange = {},
        modifier = Modifier
            .height(64.dp)
            .width(200.dp),
        header = "Имя"
    )
}