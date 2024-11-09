package com.veteran.planai.domain.user.client.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.veteran.planai.domain.user.domain.entity.UserEntity
import com.veteran.planai.domain.user.domain.enum.UserRole
import org.springframework.stereotype.Component

data class User(

    var id: String,
    var name: String,
    @JsonIgnore
    val password: String,
    val userRole: UserRole,

    ){

    @Component
    companion object{
        fun toUser(userEntity: UserEntity): User {
            return User(
                id = userEntity.id,
                name = userEntity.name,
                password = userEntity.password,
                userRole = userEntity.userRole,
            )
        }

        fun toEntity(user: User): UserEntity {
            return UserEntity(
                id = user.id,
                name = user.name,
                password = user.password,
                userRole = user.userRole,
            )
        }
    }

}