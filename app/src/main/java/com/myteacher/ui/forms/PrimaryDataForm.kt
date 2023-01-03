package com.myteacher.ui.forms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.primitives.DatePickerWithLabelColumn
import com.myteacher.ui.theme.Theme
import java.util.*

@Composable
fun PrimaryDataForm( //TODO add view model
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
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FullNameForm(
            surname = surname,
            onSurnameChanged = onSurnameChanged,
            name = name,
            onNameChanged = onNameChanged,
            patronymic = patronymic,
            onPatronymicChanged = onPatronymicChanged
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalGenderForm(
                selectedGender = selectedGender,
                onGenderSelected = onGenderSelected
            )

            DatePickerWithLabelColumn(dateState = dateState) {
                Text(
                    text = stringResource(R.string.birth_date),
                    style = Theme.typography.default
                )
            }
        }
    }
}

@Composable
@Preview
fun PrimaryDataFormPreview() {
    var surname by remember { mutableStateOf("")}
    var name by remember { mutableStateOf("")}
    var patronymic by remember { mutableStateOf("")}
    var selectedGender by remember { mutableStateOf("М")}
    val dateState = remember { mutableStateOf(Date()) }

    PrimaryDataForm(
        modifier = Modifier
            .width(720.dp)
            .height(440.dp),
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