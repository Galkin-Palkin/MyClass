package com.myteacher.ui.forms

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.primitives.InputField
import com.myteacher.ui.primitives.PasswordField

@Composable
fun UserEntryForm(
    modifier: Modifier = Modifier,
    login: String,
    onLoginChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        InputField(
            value = login,
            onValueChange = onLoginChanged,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            header = stringResource(R.string.login)
        )

        Spacer(modifier = Modifier.height(16.dp))

        PasswordField(
            value = password,
            onValueChange = onPasswordChanged,
            modifier = Modifier.fillMaxWidth(),
            header = stringResource(R.string.password)
        )
    }
}

@Composable
@Preview
fun UserEntryFormPreview() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    UserEntryForm(
        login = login,
        onLoginChanged = { login = it },
        password = password,
        onPasswordChanged = { password = it }
    )
}