package com.myteacher.viewModels.forms

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.myteacher.viewModels.fields.Contact
import com.myteacher.viewModels.fields.ContactViewModel

class ContactsViewModel : ViewModel() {
    val contacts = mutableStateListOf<ContactViewModel>()

    fun addContact(type: String) {
        val viewModel = ContactViewModel()
        viewModel.contact = mutableStateOf(Contact(type, ""))
        contacts.add(viewModel)
    }
}