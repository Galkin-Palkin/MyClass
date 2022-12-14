package com.myteacher.ui.screens.start

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.myteacher.R
import com.myteacher.ui.forms.UserEntryForm
import com.myteacher.ui.primitives.TextButton
import com.myteacher.ui.theme.Theme

//TODO add navigation
@Composable
fun AuthorizationPage(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    login: String,
    onLoginChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserEntryForm(
            login = login,
            onLoginChanged = onLoginChanged,
            password = password,
            onPasswordChanged = onPasswordChanged,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = {
                navController.navigate("")
            },
            text = stringResource(R.string.enter),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.registration),
            style = Theme.typography.small,
            modifier = Modifier.clickable {
                navController.navigate("")
            }
        )
    }
}

@Composable
@Preview
fun AuthorizationPagePreview() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    AuthorizationPage(
        navController = NavHostController(LocalContext.current),
        login = login,
        onLoginChanged = { login = it },
        password = password,
        onPasswordChanged = { password = it }
    )
}