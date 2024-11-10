package com.veteran.planai.domain.plan.application.dto.response

data class PlanDetailResponse(
    val id: Long? = null,
    val title: String,
    val description: String,
    val userId: String,
)