package com.myteacher.ui.primitives

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.myteacher.ui.theme.Theme

@Composable
fun NoBorderedInputField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    textStyle: TextStyle = Theme.typography.inputFieldInnerText
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            unfocusedLabelColor = Color.Transparent,
            focusedLabelColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            cursorColor = textStyle.color
        ),
        textStyle = textStyle
    )
}

@Composable
@Preview
fun NoBorderedInputFieldPreview() {
    var text by remember { mutableStateOf("8 800 555 35 35") }

    NoBorderedInputField(
        text = text,
        onTextChange = { text = it }
    )
}