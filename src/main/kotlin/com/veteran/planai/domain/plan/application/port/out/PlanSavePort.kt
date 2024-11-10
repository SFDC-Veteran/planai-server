package com.veteran.planai.domain.plan.application.port.out

import com.veteran.planai.domain.plan.domain.PlanEntity

interface PlanSavePort {
    fun save(entity: PlanEntity) : PlanEntity
}