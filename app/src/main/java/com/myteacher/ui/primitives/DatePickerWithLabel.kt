package com.myteacher.ui.primitives

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
fun VerticalDatePickerWithLabel(
    modifier: Modifier = Modifier,
    dateState: Date,
    context: Context = LocalContext.current,
    onDateChange: (Date) -> Unit,
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
fun HorizontalDatePickerWithLabel(
    modifier: Modifier = Modifier,
    dateState: Date,
    context: Context = LocalContext.current,
    onDateChange: (Date) -> Unit,
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
fun HorizontalDatePickerWithLabelPreview() {
    var date by remember { mutableStateOf(Date()) }

    HorizontalDatePickerWithLabel(
        dateState = date,
        onDateChange = { date = it }
    ) {
        Text(
            text = stringResource(R.string.birth_date),
            style = Theme.typography.default.copy(textAlign = TextAlign.Left)
        )
    }
}


@Composable
@Preview
fun VerticalDatePickerWithLabelPreview() {
    var date by remember { mutableStateOf(Date()) }

    VerticalDatePickerWithLabel(
        dateState = date,
        onDateChange = { date = it }
    ) {
        Text(
            text = stringResource(R.string.birth_date),
            style = Theme.typography.default.copy(textAlign = TextAlign.Left)
        )
    }
}