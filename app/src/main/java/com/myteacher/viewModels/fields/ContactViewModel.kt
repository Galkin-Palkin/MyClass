package com.myteacher.viewModels.fields

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

data class Contact(val contactType: String, val contactValue: String)

class ContactViewModel : ViewModel() {
    var contact = mutableStateOf(Contact("", ""))
}