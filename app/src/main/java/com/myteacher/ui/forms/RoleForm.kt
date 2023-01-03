package com.myteacher.ui.forms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.primitives.RadioButtonWithLabel
import com.myteacher.ui.theme.Theme

@Composable
fun RoleForm(
    modifier: Modifier = Modifier
) {
    val roles = stringArrayResource(R.array.roles)
    var selected by remember { mutableStateOf(roles[0]) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        roles.forEach {
            RadioButtonWithLabel(
                selected = it == selected,
                onClick = { selected = it },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = it,
                    style = Theme.typography.default
                )
            }
        }
    }
}