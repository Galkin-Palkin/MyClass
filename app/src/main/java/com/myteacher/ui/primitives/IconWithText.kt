package com.myteacher.ui.primitives

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.theme.Theme

@Composable
fun IconWithText(
    modifier: Modifier = Modifier,
    iconId: Int,
    text: String,
    textStyle: TextStyle = Theme.typography.default
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(iconId),
            contentDescription = null,
            tint = textStyle.color
        )

        Spacer(modifier = modifier.width(8.dp))

        Text(
            text = text,
            style = textStyle
        )
    }
}

@Composable
@Preview
fun IconWithTextPreview() {
    IconWithText(
        iconId = R.drawable.calendar,
        text = "Дата окончания путёвки"
    )
}