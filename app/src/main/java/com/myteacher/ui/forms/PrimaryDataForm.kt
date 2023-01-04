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
import com.myteacher.ui.fields.FullNameField
import com.myteacher.ui.primitives.DatePickerWithLabelColumn
import com.myteacher.ui.theme.Theme
import java.util.*

@Composable
fun PrimaryDataForm(
    modifier: Modifier = Modifier,
    surname: String,
    onSurnameChange: (String) -> Unit,
    name: String,
    onNameChange: (String) -> Unit,
    patronymic: String,
    onPatronymicChange: (String) -> Unit,
    selectedGender: String,
    onGenderSelected: (String) -> Unit,
    dateState: MutableState<Date>
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FullNameField(
            surname = surname,
            onSurnameChange = onSurnameChange,
            name = name,
            onNameChange = onNameChange,
            patronymic = patronymic,
            onPatronymicChange = onPatronymicChange
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalGenderForm(
                selectedGender = selectedGender,
                onGenderSelected = onGenderSelected
            )
            //TODO bug maybe here (not updating value)
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

    Column {
        PrimaryDataForm(
            modifier = Modifier
                .width(720.dp)
                .height(440.dp),
            surname = surname,
            onSurnameChange = { surname = it },
            name = name,
            onNameChange = { name = it },
            patronymic = patronymic,
            onPatronymicChange = { patronymic = it },
            selectedGender = selectedGender,
            onGenderSelected = { selectedGender = it },
            dateState = dateState
        )

        Text(dateState.value.toString())
    }
}