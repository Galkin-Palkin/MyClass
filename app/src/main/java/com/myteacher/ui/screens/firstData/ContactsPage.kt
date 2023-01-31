package com.myteacher.ui.screens.firstData

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

@Composable
fun ContactsPage(navController: NavHostController) {
    val viewModel: HumanInfoViewModel = viewModel()
    val contacts by viewModel.contacts.collectAsState()
    val scope = rememberCoroutineScope()

    ScreenPattern {
        ContactsForm(
            modifier = Modifier,
            contacts = contacts,
            onContactAdd = { type -> scope.launch {
                viewModel.addContact(type)
            } },
            onContactDelete = { contact -> scope.launch {
                viewModel.removeContact(contact)
            } },
            onContactChange = { contact, value -> scope.launch {
                viewModel.changeContact(contact, value)
            }},
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