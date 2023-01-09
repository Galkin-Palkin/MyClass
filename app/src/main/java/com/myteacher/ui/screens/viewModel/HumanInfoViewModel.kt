package com.myteacher.ui.screens.viewModel

import androidx.lifecycle.ViewModel
import com.myteacher.data.model.humanInfo.FullName
import com.myteacher.data.model.humanInfo.Gender
import com.myteacher.data.model.humanInfo.HumanInfo
import com.myteacher.data.model.humanInfo.UserInfo
import kotlinx.coroutines.flow.MutableStateFlow
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

    private val _contacts = MutableStateFlow(humanInfo.contacts)

    val contacts get() = _contacts

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