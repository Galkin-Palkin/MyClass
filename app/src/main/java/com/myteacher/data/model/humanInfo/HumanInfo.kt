package com.myteacher.data.model.humanInfo

import java.util.*

data class HumanInfo(
    val id: Int,
    val fullName: FullName,
    val birthDate: Date,
    val gender: Gender,
    val contacts: List<Contact>,
    val user: Optional<UserInfo>
)
