package com.myteacher.ui.screens.firstData

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.myteacher.R
import com.myteacher.ui.forms.PrimaryDataForm
import com.myteacher.ui.navigation.Routes
import com.myteacher.ui.screens.viewModel.HumanInfoViewModel
import com.myteacher.ui.theme.Theme

@Composable
fun DataPage(navController: NavHostController) {
    val viewModel: HumanInfoViewModel = viewModel()

    ScreenPattern {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Text(
                text = stringResource(R.string.your_data),
                style = Theme.typography.h3.copy(color = Theme.colors.primaryText)
            )

            PrimaryDataForm(
                surname = viewModel.surname.collectAsState().value,
                onSurnameChange = { viewModel.surname.value = it },
                name = viewModel.name.collectAsState().value,
                onNameChange = { viewModel.name.value = it },
                patronymic = viewModel.patronymic.collectAsState().value,
                onPatronymicChange = { viewModel.patronymic.value = it },
                selectedGender = viewModel.gender.collectAsState().value.value,
                onGenderSelected = { viewModel.setGender(it) },
                dateState = viewModel.birthDate.collectAsState().value,
                onDateSelected = { viewModel.birthDate.value = it },
                onClick = {
                    navController.navigate(Routes.Page.Contacts.route)
                }
            )
        }
    }
}

@Composable
@Preview
fun DataPagePreview() {
    DataPage(rememberNavController())
}