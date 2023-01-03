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

@Composable
fun FullNameForm( //TODO add view model
    modifier: Modifier = Modifier,
    surname: String,
    onSurnameChanged: (String) -> Unit,
    name: String,
    onNameChanged: (String) -> Unit,
    patronymic: String,
    onPatronymicChanged: (String) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        InputField(
            value = surname,
            onValueChange = onSurnameChanged,
            header = stringResource(R.string.surname)
        )

        InputField(
            value = name,
            onValueChange = onNameChanged,
            header = stringResource(R.string.name)
        )

        InputField(
            value = patronymic,
            onValueChange = onPatronymicChanged,
            header = stringResource(R.string.patronymic)
        )
    }
}

@Composable
@Preview
fun FullNameFormPreview() {
    var surname by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var patronymic by remember { mutableStateOf("") }

    FullNameForm(
        surname = surname,
        onSurnameChanged = { surname = it },
        name = name,
        onNameChanged = { name = it},
        patronymic = patronymic,
        onPatronymicChanged = { patronymic = it }
    )
}