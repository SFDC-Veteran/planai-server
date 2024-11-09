package com.veteran.planai.domain.user.domain.entity

import com.veteran.planai.domain.user.domain.enum.UserRole
import jakarta.persistence.*
import org.hibernate.annotations.DynamicUpdate

@Entity
@DynamicUpdate
@Table(name = "tb_user")
class UserEntity(

    @Id
    @Column(unique = true)
    var id: String,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var password: String,

    @Enumerated(EnumType.STRING)
    var userRole: UserRole,

)