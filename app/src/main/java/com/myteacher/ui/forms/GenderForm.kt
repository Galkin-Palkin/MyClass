package com.myteacher.ui.forms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.primitives.RadioButtonWithLabel
import com.myteacher.ui.theme.Theme

@Composable
fun GenderForm(
    modifier: Modifier = Modifier,
    selectedGender: String,
    onGenderSelected: (String) -> Unit
) {
    val genders = stringArrayResource(R.array.genders)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.gender),
            style = Theme.typography.h4.copy(color = Theme.colors.primaryText)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .selectableGroup(),
            horizontalArrangement = Arrangement.Center
        ) {
            genders.forEach { gender ->
                RadioButtonWithLabel(
                    selected = (gender == selectedGender),
                    onClick = { onGenderSelected(gender) }
                ) {
                    Text(
                        text = gender,
                        style = Theme.typography.default
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun GenderFormPreview() {
    val startValue = stringArrayResource(R.array.genders)[0]
    val (selectedGender, onGenderSelected) = remember { mutableStateOf(startValue) }

    GenderForm(
        selectedGender = selectedGender,
        onGenderSelected = onGenderSelected
    )
}