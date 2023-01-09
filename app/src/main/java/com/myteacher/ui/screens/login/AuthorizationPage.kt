package com.myteacher.ui.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.myteacher.R
import com.myteacher.ui.forms.UserEntryForm
import com.myteacher.ui.navigation.Routes
import com.myteacher.ui.primitives.TextButton
import com.myteacher.ui.screens.login.ScreenPattern
import com.myteacher.ui.screens.viewModel.HumanInfoViewModel
import com.myteacher.ui.theme.Theme

@Composable
fun AuthorizationPage(navController: NavHostController) {
    val viewModel: HumanInfoViewModel = viewModel()
    val login by viewModel.login.collectAsState()
    val passwordSalt by viewModel.passwordSalt.collectAsState()

    ScreenPattern {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            UserEntryForm(
                login = login,
                onLoginChanged = { viewModel.login.value = it },
                password = passwordSalt,
                onPasswordChanged = { viewModel.passwordSalt.value },
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    //TODO add navigation
                }
            )

            Text(
                text = stringResource(R.string.registration),
                style = Theme.typography.small,
                modifier = Modifier.clickable {
                    navController.navigate(Routes.Page.Registration.route)
                }
            )
        }
    }
}

@Composable
@Preview
fun AuthorizationPagePreview() {
    AuthorizationPage(rememberNavController())
}