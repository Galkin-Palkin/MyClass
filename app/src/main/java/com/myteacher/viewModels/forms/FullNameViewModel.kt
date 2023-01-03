package com.myteacher.viewModels.forms

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FullNameViewModel(
    surname: String = "",
    name: String = "",
    patronymic: String = ""
) : ViewModel() {
    private var _surname = MutableStateFlow(surname)
    val surname = _surname.asStateFlow()

    private var _name = MutableStateFlow(name)
    val name = _name.asStateFlow()

    private var _patronymic = MutableStateFlow(patronymic)
    val patronymic = _patronymic.asStateFlow()

    fun setSurname(value: String) {
        _surname.value = value
    }

    fun setName(value: String) {
        _name.value = value
    }

    fun setPatronymic(value: String) {
        _patronymic.value = value
    }
}