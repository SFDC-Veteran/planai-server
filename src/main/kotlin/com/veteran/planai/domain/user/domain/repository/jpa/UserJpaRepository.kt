package com.veteran.planai.domain.user.domain.repository.jpa

import com.veteran.planai.domain.user.domain.entity.UserEntity
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserJpaRepository : JpaRepository<UserEntity, Long> {
    fun findById(id: String): Optional<UserEntity>
    @Transactional(rollbackOn = [Exception::class])
    fun deleteById(id: String)
    fun existsById(id: String): Boolean
}