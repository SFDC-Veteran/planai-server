package com.veteran.planai.domain.plan.application.port.out

interface PlanDeletePort {
    fun deleteById(id: Long)
}