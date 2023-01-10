package com.myteacher.ui.screens.viewModel

import androidx.lifecycle.ViewModel
import com.myteacher.data.model.humanInfo.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.sql.Date
import java.util.*

class HumanInfoViewModel : ViewModel() {
    private val humanInfo = getInfo()

    private val _surname = MutableStateFlow(humanInfo.fullName.surname)

    val surname get() = _surname

    private val _name = MutableStateFlow(humanInfo.fullName.name)

    val name get() = _name

    private val _patronymic = MutableStateFlow(humanInfo.fullName.patronymic)

    val patronymic get() = _patronymic

    private val _birthDate = MutableStateFlow(humanInfo.birthDate)

    val birthDate get() = _birthDate

    private val _gender = MutableStateFlow(humanInfo.gender)

    val gender get() = _gender

    private val _contacts = MutableStateFlow(humanInfo.contacts.toMutableList())

    val contacts: StateFlow<List<Contact>> get() = _contacts

    fun addContact(type: String) {
        _contacts.value.add(Contact(type, "", UUID.randomUUID()))
    }

    fun removeContact(contact: Contact) {
        _contacts.value.remove(contact)
    }

    fun changeContact(contact: Contact, value: String) {
        val id = _contacts.value.indexOfFirst { _contact -> _contact.id == contact.id }

        _contacts.value[id] = contact.copy(value = value)
    }

    private val _login =
        MutableStateFlow(if (humanInfo.user.isPresent) humanInfo.user.get().login else "")

    val login get() = _login

    private val _passwordSalt =
        MutableStateFlow(if (humanInfo.user.isPresent) humanInfo.user.get().passwordSalt else "")

    val passwordSalt get() = _passwordSalt

    private fun getInfo() : HumanInfo {
        //TODO make getting info from server
        return HumanInfo(
            id = 0,
            fullName = FullName(
                surname = "",
                name = "",
                patronymic = ""
            ),
            birthDate = Date(1668816000),
            gender = Gender("М"),
            contacts = listOf(),
            user = Optional.of(UserInfo(
                login = "",
                passwordSalt = ""
            ))
        )
    }
}