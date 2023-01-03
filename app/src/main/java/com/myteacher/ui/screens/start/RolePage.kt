package com.myteacher.ui.screens.start

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.forms.RoleForm
import com.myteacher.ui.primitives.CustomButton
import com.myteacher.ui.theme.Theme

@Composable
fun RolePage(
    modifier: Modifier = Modifier,
    //TODO add view model
) {
    Column(
        modifier = modifier,
    ) {
        RoleForm() //TODO add view model

        Spacer(modifier = Modifier.height(64.dp))

        CustomButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

            },
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
fun RolePagePreview() {
    RolePage()
}