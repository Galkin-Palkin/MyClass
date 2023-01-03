package com.myteacher.ui.forms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.primitives.InputField
import com.myteacher.viewModels.forms.FullNameViewModel

@Composable
fun FullNameForm( //TODO add view model
    modifier: Modifier = Modifier,
    viewModel: FullNameViewModel
) {
    val surname by remember { mutableStateOf(viewModel.surname.value) }
    val name by remember { mutableStateOf(viewModel.name.value) }
    val patronymic by remember { mutableStateOf(viewModel.patronymic.value) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        InputField(
            value = surname,
            onValueChange = { viewModel.setSurname(surname) },
            header = stringResource(R.string.surname)
        )

        InputField(
            value = name,
            onValueChange = { viewModel.setName(name) },
            header = stringResource(R.string.name)
        )

        InputField(
            value = patronymic,
            onValueChange = { viewModel.setPatronymic(patronymic) },
            header = stringResource(R.string.patronymic)
        )
    }
}

@Composable
@Preview
fun FullNameFormPreview() {
    FullNameForm(viewModel = FullNameViewModel())
}