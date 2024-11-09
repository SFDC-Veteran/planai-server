package com.veteran.planai.domain.user.usecase

import com.veteran.planai.domain.user.client.dto.Profile
import com.veteran.planai.domain.user.client.dto.User
import com.veteran.planai.domain.user.client.dto.request.UserEditRequest
import com.veteran.planai.domain.user.service.UserService
import com.veteran.planai.global.common.repository.UserSecurity
import com.veteran.planai.global.s3.S3
import org.springframework.stereotype.Service

@Service
class UserUseCase(
    private val userSecurity: UserSecurity,
    private val userService: UserService,
    private val s3: S3
) {

    fun getUser(): User {
        return userSecurity.getUser()
    }

    fun deleteUser() {
        val email: String = userSecurity.getUser().id
        userService.checkUserExistByEmail(email)
        userService.deleteUser(email)
    }

    fun editUser(request: UserEditRequest){
        val user: User = userService.getUser(userSecurity.getUser().id)
        user.name = request.name
        userService.saveUser(user)
    }

    fun getUserProfile(): Profile {
        return userService.getProfile()
    }

}