package com.myteacher.ui.architecture

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.theme.Theme

@Composable
fun Header() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(104.dp)
            .background(Theme.colors.appHeaderBackground),
        elevation = Theme.elevation.default,
        shape = RoundedCornerShape(ZeroCornerSize)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 8.dp, 32.dp, 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                style = Theme.typography.h2.copy(color = Theme.colors.primaryText)
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.three_dots),
                contentDescription = null,
                tint = Theme.colors.primaryText
            )
        }
    }
}

@Composable
@Preview
fun HeaderPreview() {
    Header()
}