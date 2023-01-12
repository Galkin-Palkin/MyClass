package com.myteacher.ui.screens.firstData

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
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
    val surname by viewModel.surname.collectAsState()
    val name by viewModel.name.collectAsState()
    val patronymic by viewModel.patronymic.collectAsState()
    val gender by viewModel.gender.collectAsState()
    val birthDate by viewModel.birthDate.collectAsState()

    ScreenPattern {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(160.dp))

            Text(
                text = stringResource(R.string.your_data),
                style = Theme.typography.h3.copy(color = Theme.colors.primaryText)
            )

            PrimaryDataForm(
                surname = surname,
                onSurnameChange = { viewModel.surname.value = it },
                name = name,
                onNameChange = { viewModel.name.value = it },
                patronymic = patronymic,
                onPatronymicChange = { viewModel.patronymic.value = it },
                selectedGender = gender.value,
                onGenderSelected = { viewModel.setGender(it) },
                dateState = birthDate,
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