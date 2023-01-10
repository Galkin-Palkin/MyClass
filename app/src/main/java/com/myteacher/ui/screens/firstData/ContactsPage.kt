package com.myteacher.ui.screens.firstData

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.myteacher.R
import com.myteacher.ui.forms.ContactsForm
import com.myteacher.ui.navigation.Routes
import com.myteacher.ui.screens.viewModel.HumanInfoViewModel

@Composable
fun ContactsPage(navController: NavHostController) {
    val viewModel: HumanInfoViewModel = viewModel()
    val contacts by viewModel.contacts.collectAsState()

    ScreenPattern {
        ContactsForm(
            modifier = Modifier.fillMaxWidth(),
            contacts = contacts,
            onContactAdd = { type -> viewModel.addContact(type) },
            onContactDelete = { contact -> viewModel.removeContact(contact) },
            onContactChange = { contact, value -> viewModel.changeContact(contact, value)},
            buttonText = stringResource(R.string.next),
            onButtonClick = {
                navController.navigate(Routes.Page.Role.route)
            }
        )
    }
}

@Composable
@Preview
fun ContactsPagePreview() {
    ContactsPage(rememberNavController())
}