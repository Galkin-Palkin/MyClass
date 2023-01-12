package com.myteacher.ui.forms

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.myteacher.R
import com.myteacher.data.model.humanInfo.Contact
import com.myteacher.ui.fields.ContactField
import com.myteacher.ui.primitives.DropMenu
import com.myteacher.ui.primitives.TextButton
import com.myteacher.ui.primitives.ThemeCard
import com.myteacher.ui.screens.viewModel.HumanInfoViewModel
import com.myteacher.ui.theme.Theme

//TODO fix size bug
//TODO fix alignment and arrangement
//TODO fix minus button size
//TODO fix text displaying (now its transparent)
@Composable
fun ContactsForm(
    modifier: Modifier = Modifier,
    contacts: List<Contact>,
    onContactAdd: (String) -> Unit,
    onContactDelete: (Contact) -> Unit,
    onContactChange: (Contact, String) -> Unit,
    buttonText: String,
    onButtonClick: () -> Unit
) {
    val contactTypes = stringArrayResource(R.array.contacts).toList()
    var selectedItem by remember { mutableStateOf(contactTypes[0]) }

    Column(
        modifier = modifier
    ) {
        ThemeCard(modifier = Modifier.fillMaxWidth()) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    DropMenu(
                        list = stringArrayResource(R.array.contacts).toList(),
                        onSelectedChange = { selectedItem = it },
                        placeholder = selectedItem,
                        toDisplay = { return@DropMenu it }
                    )

                    IconButton(
                        onClick = { onContactAdd(selectedItem) }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_plus),
                            contentDescription = null,
                            tint = Theme.colors.primary,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }

                Divider()

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    contacts.forEach { contact ->
                        ContactField(
                            contactType = contact.type,
                            contactValue = contact.value,
                            onContactChange = { contactValue -> onContactChange(contact, contactValue) },
                            onMinusClicked = { onContactDelete(contact) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                        )
                    }
                }
            }
        }

        TextButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = onButtonClick,
            text = buttonText
        )
    }
}

@Composable
@Preview
fun ContactsFormPreview() {
    val viewModel: HumanInfoViewModel = viewModel()
    val contacts by viewModel.contacts.collectAsState()

    ContactsForm(
        contacts = contacts,
        onContactAdd = { viewModel.addContact(it) },
        onContactDelete = { viewModel.removeContact(it) },
        onContactChange = { contact, value -> viewModel.changeContact(contact, value) },
        buttonText = stringResource(R.string.next)
    ) {

    }
}