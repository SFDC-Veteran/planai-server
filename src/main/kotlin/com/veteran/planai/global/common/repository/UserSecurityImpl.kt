package com.veteran.planai.global.common.repository

import com.veteran.planai.domain.user.client.dto.User
import com.veteran.planai.global.security.auth.CustomUserDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Repository

@Repository
class UserSecurityImpl() : UserSecurity {

    override fun getUser(): User {
        val user: User = (SecurityContextHolder
            .getContext()
            .authentication
            .principal as CustomUserDetails).getUser()
        return user
    }

}