package com.myteacher.ui.fields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.primitives.NoBorderedInputField
import com.myteacher.ui.theme.Theme

@Composable
fun ContactField(
    modifier: Modifier = Modifier,
    contactType: String,
    contactValue: MutableState<String>,
    onContactChange: (String) -> Unit,
    onMinusClicked: () -> Unit,
    textStyle: TextStyle = Theme.typography.inputFieldInnerText
) {
    Row(
        modifier = modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = contactType,
            style = textStyle
        )

        NoBorderedInputField(
            text = contactValue.value,
            onTextChange = onContactChange
        )

        IconButton(
            onClick = onMinusClicked,
            modifier = Modifier.width(32.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_minus),
                contentDescription = null,
                tint = Theme.colors.primary,
            )
        }
    }
}