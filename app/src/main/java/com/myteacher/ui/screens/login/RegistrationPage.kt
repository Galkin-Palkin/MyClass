package com.myteacher.ui.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.myteacher.R
import com.myteacher.ui.forms.UserEntryForm
import com.myteacher.ui.navigation.Routes
import com.myteacher.ui.primitives.CheckBoxWithLabel
import com.myteacher.ui.screens.viewModel.HumanInfoViewModel
import com.myteacher.ui.theme.Theme

@Composable
fun RegistrationPage(navController: NavHostController) {
    var checked by remember { mutableStateOf(false) }
    val viewModel: HumanInfoViewModel = viewModel()
    val login by viewModel.login.collectAsState()
    val passwordSalt by viewModel.passwordSalt.collectAsState()

    ScreenPattern {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(R.string.registration),
                style = Theme.typography.h3.copy(color = Theme.colors.primaryText),
            )

            UserEntryForm(
                login = login,
                onLoginChanged = { viewModel.login.value = it },
                password = passwordSalt,
                onPasswordChanged = { viewModel.passwordSalt.value = it },
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(Routes.Screen.FirstData.route) },
                betweenContent = {
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
                }
            )
        }
    }
}

@Composable
@Preview
fun RegistrationPagePreview() {
    RegistrationPage(NavHostController(LocalContext.current))
}