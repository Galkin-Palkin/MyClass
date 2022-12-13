package com.myteacher.ui.primitives

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.ui.theme.Theme
import java.util.*

@Composable
fun DatePickerWithLabel(
    modifier: Modifier = Modifier,
    dateState: MutableState<Date>,
    context: Context = LocalContext.current,
    onDateChange: () -> Unit = {},
    label: @Composable () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        label()

        Spacer(modifier = Modifier.height(8.dp))

        DatePicker(
            dateState = dateState,
            modifier = modifier,
            context = context,
            onDateChange = onDateChange
        )
    }
}

@Composable
@Preview
fun DatePickerWithLabelPreview() {
    val state = remember { mutableStateOf(Date()) }

    DatePickerWithLabel(
        dateState = state
    ) {
        Text(
            text = "Дата рождения",
            style = Theme.typography.default.copy(textAlign = TextAlign.Left)
        )
    }
}