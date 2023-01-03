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
    onSelectedChange: (T) -> Unit,
    placeholder: String,
    toDisplay: (T) -> String
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
                    text = toDisplay(it),
                    style = Theme.typography.default,
                    modifier = Modifier.clickable {
                        onSelectedChange(it)
                        selected = toDisplay(it)
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
    var item by remember { mutableStateOf("") }

    Column {
        DropMenu(
            list = listOf("Отстутствуют", "Под заключением", "Что-то ещё"),
            onSelectedChange = { item = it },
            placeholder = "Выбрать",
            toDisplay = { return@DropMenu it }
        )

        Text(item)
    }
}