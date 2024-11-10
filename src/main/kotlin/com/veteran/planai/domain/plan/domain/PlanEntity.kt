package com.veteran.planai.domain.plan.domain

import jakarta.persistence.*
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Table(name = "plan")
@Entity
@DynamicUpdate
@DynamicInsert
class PlanEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String,
    @Column(length = 50000)
    var description: String,
    var userId: String,
)