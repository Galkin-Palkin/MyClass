package com.myteacher.ui.forms

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.primitives.CustomButton
import com.myteacher.ui.primitives.RadioButtonWithLabel
import com.myteacher.ui.theme.Theme

@Composable
fun RoleForm(
    modifier: Modifier = Modifier,
    role: String,
    onRoleChange: () -> Unit,
    onButtonClick: () -> Unit,
) {
    val roles = stringArrayResource(R.array.roles)

    Column(
        modifier = modifier,
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            roles.forEach {
                RadioButtonWithLabel(
                    selected = it == role,
                    onClick = onRoleChange,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = it,
                        style = Theme.typography.default
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(64.dp))

        CustomButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = onButtonClick,
            content = {
                Text(
                    text = stringResource(R.string.next),
                    style = Theme.typography.button
                )
            }
        )
    }
}

@Composable
@Preview
fun RoleFormPreview() {
    //TODO
}