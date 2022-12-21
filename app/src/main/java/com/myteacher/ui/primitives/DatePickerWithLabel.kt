package com.myteacher.ui.primitives

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.theme.Theme
import java.util.*

@Composable
fun DatePickerWithLabelColumn(
    modifier: Modifier = Modifier,
    dateState: MutableState<Date>,
    context: Context = LocalContext.current,
    onDateChange: () -> Unit = {},
    label: @Composable () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        label()

        Spacer(modifier = Modifier.height(8.dp))

        DatePicker(
            dateState = dateState,
            context = context,
            onDateChange = onDateChange
        )
    }
}

@Composable
fun DatePickerWithLabelRow(
    modifier: Modifier = Modifier,
    dateState: MutableState<Date>,
    context: Context = LocalContext.current,
    onDateChange: () -> Unit = {},
    label: @Composable () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        label()

        Spacer(modifier = Modifier.width(8.dp))

        DatePicker(
            dateState = dateState,
            context = context,
            onDateChange = onDateChange
        )
    }
}

@Composable
@Preview
fun DatePickerWithLabelRowPreview() {
    val state = remember { mutableStateOf(Date()) }

    DatePickerWithLabelRow(
        dateState = state
    ) {
        Text(
            text = stringResource(R.string.birth_date),
            style = Theme.typography.default.copy(textAlign = TextAlign.Left)
        )
    }
}


@Composable
@Preview
fun DatePickerWithLabelColumnPreview() {
    val state = remember { mutableStateOf(Date()) }

    DatePickerWithLabelColumn(
        dateState = state
    ) {
        Text(
            text = stringResource(R.string.birth_date),
            style = Theme.typography.default.copy(textAlign = TextAlign.Left)
        )
    }
}