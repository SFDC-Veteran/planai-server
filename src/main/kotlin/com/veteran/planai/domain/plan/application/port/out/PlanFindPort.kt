package com.veteran.planai.domain.plan.application.port.out

import com.veteran.planai.domain.plan.domain.PlanEntity

interface PlanFindPort {
    fun findById(id: Long): PlanEntity
    fun findByUserId(userId: String): List<PlanEntity>?
}