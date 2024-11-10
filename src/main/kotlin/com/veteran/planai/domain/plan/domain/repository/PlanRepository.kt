package com.veteran.planai.domain.plan.domain.repository

import com.veteran.planai.domain.plan.domain.PlanEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PlanRepository: JpaRepository<PlanEntity, Long> {
    fun findByUserId(userId: String): List<PlanEntity>?
}