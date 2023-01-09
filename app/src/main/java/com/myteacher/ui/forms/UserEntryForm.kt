package com.myteacher.ui.forms

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.primitives.InputField
import com.myteacher.ui.primitives.PasswordField
import com.myteacher.ui.primitives.TextButton

@Composable
fun UserEntryForm(
    modifier: Modifier = Modifier,
    login: String,
    onLoginChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    onClick: () -> Unit,
    betweenContent: @Composable () -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        InputField(
            value = login,
            onValueChange = onLoginChanged,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            header = stringResource(R.string.login)
        )

        PasswordField(
            value = password,
            onValueChange = onPasswordChanged,
            modifier = Modifier.fillMaxWidth(),
            header = stringResource(R.string.password)
        )

        betweenContent()

        TextButton(
            onClick = onClick,
            text = stringResource(R.string.enter),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
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
        onPasswordChanged = { password = it },
        onClick = {}
    )
}