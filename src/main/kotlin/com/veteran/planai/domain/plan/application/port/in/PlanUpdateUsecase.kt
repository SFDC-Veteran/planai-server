package com.veteran.planai.domain.plan.application.port.`in`

import com.veteran.planai.domain.plan.application.dto.request.PlanEditRequest
import com.veteran.planai.global.common.dto.response.BaseResponse

interface PlanUpdateUsecase {
    fun update(request: PlanEditRequest):BaseResponse
}