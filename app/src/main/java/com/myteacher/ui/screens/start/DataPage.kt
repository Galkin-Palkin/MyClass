package com.myteacher.ui.screens.start

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.forms.PrimaryDataForm
import com.myteacher.ui.primitives.CustomButton
import com.myteacher.ui.theme.Theme
import java.util.*

@Composable
fun DataPage(
    modifier: Modifier = Modifier,
    surname: String,
    onSurnameChanged: (String) -> Unit,
    name: String,
    onNameChanged: (String) -> Unit,
    patronymic: String,
    onPatronymicChanged: (String) -> Unit,
    selectedGender: String,
    onGenderSelected: (String) -> Unit,
    dateState: MutableState<Date>
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Text(
            text = stringResource(R.string.your_data),
            style = Theme.typography.h3.copy(color = Theme.colors.primaryText)
        )

        PrimaryDataForm(
            surname = surname,
            onSurnameChanged = onSurnameChanged,
            name = name,
            onNameChanged = onNameChanged,
            patronymic = patronymic,
            onPatronymicChanged = onPatronymicChanged,
            selectedGender = selectedGender,
            onGenderSelected = onGenderSelected,
            dateState = dateState
        )

        CustomButton(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.8f), //TODO fix this strange thing :)
            onClick = {
                //TODO add navigation
            },
            content = {
                Text(
                    text = stringResource(R.string.next),
                    style = Theme.typography.button.copy(color = Theme.colors.onPrimary)
                )
            }
        )
    }
}

@Composable
@Preview
fun DataPagePreview() {
    var surname by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var patronymic by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("М") }
    val dateState = remember { mutableStateOf(Date()) }

    DataPage(
        modifier = Modifier.width(720.dp),
        surname = surname,
        onSurnameChanged = { surname = it },
        name = name,
        onNameChanged = { name = it },
        patronymic = patronymic,
        onPatronymicChanged = { patronymic = it },
        selectedGender = selectedGender,
        onGenderSelected = { selectedGender = it },
        dateState = dateState
    )
}