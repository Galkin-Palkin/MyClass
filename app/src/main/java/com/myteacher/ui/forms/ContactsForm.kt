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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myteacher.R
import com.myteacher.ui.fields.ContactField
import com.myteacher.ui.primitives.DropMenu
import com.myteacher.ui.primitives.ThemeCard
import com.myteacher.ui.theme.Theme
import com.myteacher.viewModels.forms.ContactsViewModel

//TODO fix alignment and arrangement
//TODO fix minus button size
//TODO fix text displaying (now its transparent)
@Composable
fun ContactsForm(
    modifier: Modifier = Modifier,
    contactsViewModel: ContactsViewModel,
) {
    val contactTypes = stringArrayResource(R.array.contacts).toList()
    var selectedItem by remember { mutableStateOf(contactTypes[0]) }

    ThemeCard(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
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
                    onClick = {
                        contactsViewModel.addContact(selectedItem)
                    }
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
                contactsViewModel.contacts.forEach { viewModel ->
                    ContactField(
                        contactName = viewModel.contact.value.contactType,
                        contactValue = viewModel.contact.value.contactValue,
                        onContactChange = {
                            viewModel.contact.value = viewModel.contact.value.copy(contactValue = it)
                        },
                        onMinusClicked = {
                            contactsViewModel.contacts.remove(viewModel)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun ContactsFormPreview() {
    ContactsForm(contactsViewModel = ContactsViewModel())
}