package com.myteacher.ui.primitives

import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.icu.util.GregorianCalendar
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.theme.Theme
import java.util.*

@Composable
fun DatePicker(
    modifier: Modifier = Modifier,
    dateState: Date?,
    context: Context = LocalContext.current,
    onDateChange: (Date) -> Unit = {}
) {
    val calendar = Calendar.getInstance()
    val year: Int = calendar.get(Calendar.YEAR)
    val month: Int = calendar.get(Calendar.MONTH)
    val day: Int = calendar.get(Calendar.DAY_OF_MONTH)
    val date = remember { mutableStateOf(dateState?.toString() ?: "ДД.ММ.ГГГГ") }
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, dialogYear: Int, dialogMonth: Int, dialogDay: Int ->
            date.value = "${dialogDay / 10}${dialogDay % 10}.${(dialogMonth + 1) / 10}${(dialogMonth + 1) % 10}.$dialogYear"
            onDateChange(GregorianCalendar(dialogYear, dialogMonth, dialogDay).time)
        }, year, month, day
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(32.dp)
            .then(modifier)
    ) {
        Icon(
            ImageVector.vectorResource(R.drawable.calendar),
            contentDescription = null,
            modifier = Modifier.clickable {
                datePickerDialog.show()
            },
            tint = Theme.colors.primaryText
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = date.value,
            style = Theme.typography.dropDownMenuText.copy(textAlign = TextAlign.Center),
            modifier = Modifier.clickable {
                datePickerDialog.show()
            }
        )
    }
}