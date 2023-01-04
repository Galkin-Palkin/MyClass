package com.myteacher.ui.fields

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
fun FullNameField(
    modifier: Modifier = Modifier,
    surname: String,
    onSurnameChange: (String) -> Unit,
    name: String,
    onNameChange: (String) -> Unit,
    patronymic: String,
    onPatronymicChange: (String) -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        InputField(
            value = surname,
            onValueChange = onSurnameChange,
            header = stringResource(R.string.surname)
        )

        InputField(
            value = name,
            onValueChange = onNameChange,
            header = stringResource(R.string.name)
        )

        InputField(
            value = patronymic,
            onValueChange = onPatronymicChange,
            header = stringResource(R.string.patronymic)
        )
    }
}

@Composable
@Preview
fun FullNameFieldPreview() {
    var surname by remember { mutableStateOf("")}
    var name by remember { mutableStateOf("")}
    var patronymic by remember { mutableStateOf("")}

    FullNameField(
        surname = surname,
        onSurnameChange = { surname = it },
        name = name,
        onNameChange = { name = it},
        patronymic = patronymic,
        onPatronymicChange = { patronymic = it }
    )
}