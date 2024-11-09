package com.veteran.planai.global.common.repository

import com.veteran.planai.domain.user.client.dto.User

interface UserSecurity {

    fun getUser(): User

}