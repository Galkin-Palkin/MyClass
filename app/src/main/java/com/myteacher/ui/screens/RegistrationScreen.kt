package com.myteacher.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.myteacher.ui.theme.MyTeacherTheme

@Composable
fun RegistrationScreen() {
    MyTeacherTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {

        }
    }
}

@Composable
@Preview(showBackground = true)
fun RegistrationScreenPreview() {

}