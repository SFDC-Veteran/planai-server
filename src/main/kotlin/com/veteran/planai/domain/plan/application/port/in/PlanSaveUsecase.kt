package com.veteran.planai.domain.plan.application.port.`in`

import com.veteran.planai.domain.plan.application.dto.request.PlanRequest
import com.veteran.planai.global.common.dto.response.BaseResponseData

interface PlanSaveUsecase {
    fun save(request: PlanRequest) : BaseResponseData<Long>
}