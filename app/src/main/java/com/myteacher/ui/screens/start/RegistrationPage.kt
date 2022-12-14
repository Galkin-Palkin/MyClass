package com.myteacher.ui.screens.start

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.myteacher.R
import com.myteacher.ui.forms.UserEntryForm
import com.myteacher.ui.primitives.CheckBoxWithLabel
import com.myteacher.ui.primitives.TextButton
import com.myteacher.ui.theme.Theme

@Composable
fun RegistrationPage(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    login: String,
    onLoginChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit
) {
    var checked by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.registration),
            style = Theme.typography.h3.copy(color = Theme.colors.primaryText),
        )

        UserEntryForm(
            login = login,
            onLoginChanged = onLoginChanged,
            password = password,
            onPasswordChanged = onPasswordChanged,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        CheckBoxWithLabel(
            checked = checked,
            onCheckedChange = { checked = !checked }
        ) {
            Text(
                text = stringResource(R.string.user_agreement),
                style = Theme.typography.small.copy(textDecoration = TextDecoration.Underline),
                modifier = Modifier.clickable {
                    //TODO open user agreement
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(
            onClick = {
                navController.navigate("")
            },
            text = stringResource(R.string.enter),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
    }
}

@Composable
@Preview
fun RegistrationPagePreview() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    RegistrationPage(
        navController = NavHostController(LocalContext.current),
        login = login,
        onLoginChanged = { login = it },
        password = password,
        onPasswordChanged = { password = it },
        modifier = Modifier.width(680.dp)
    )
}