package com.veteran.planai.domain.user.service

import com.veteran.planai.domain.user.client.dto.Profile
import com.veteran.planai.domain.user.client.dto.User
import com.veteran.planai.domain.user.domain.repository.jpa.UserJpaRepository
import com.veteran.planai.domain.user.exception.UserNotFoundException
import com.veteran.planai.global.common.repository.UserSecurity
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userJpaRepository: UserJpaRepository,
    private val userSecurity: UserSecurity,
) {

    fun getUser(id: String): User {
        return userJpaRepository
            .findById(id)
            .map { userEntity -> User.toUser(userEntity) }
            .orElseThrow{ UserNotFoundException }
    }

    fun deleteUser(id: String) {
        userJpaRepository.deleteById(id)
    }

    fun checkUserExistByEmail(id: String) {
        if(userJpaRepository.findById(id).isEmpty){
            throw UserNotFoundException
        }
    }

    fun saveUser(user: User) {
        userJpaRepository.save(User.toEntity(user))
    }

    fun getProfile() : Profile {
        val user = userSecurity.getUser()
        return Profile(
            user.id,
            user.name,
//            profileImageRepository.findByUserId(user.id)?.imageUrl
        )
    }

}