package com.veteran.planai.domain.plan.application.port.`in`

import com.veteran.planai.global.common.dto.response.BaseResponse

interface PlanDeleteUsecase {
    fun deleteById(planId: Long) : BaseResponse
}