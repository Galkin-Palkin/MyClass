package com.myteacher.ui.primitives

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.myteacher.ui.theme.Theme

@Composable
fun <T> DropMenu(
    list: List<T>,
    selectedState: MutableState<T>,
    placeholder: String,
) {
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf(placeholder) }

    Text(
        text = selected,
        style = Theme.typography.dropDownMenuText,
        modifier = Modifier.clickable {
            expanded = true
        }
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            list.forEach {
                Text(
                    text = it.toString(),
                    style = Theme.typography.default,
                    modifier = Modifier.clickable {
                        selectedState.value = it
                        selected = it.toString()
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
@Preview
fun DropMenuPreview() {
    val state = remember { mutableStateOf("") }

    DropMenu(
        list = listOf("Отстутствуют", "Под заключением", "Что-то ещё"),
        selectedState = state,
        placeholder = "Выбрать"
    )
}