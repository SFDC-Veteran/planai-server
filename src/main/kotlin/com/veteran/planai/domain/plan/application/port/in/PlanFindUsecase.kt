package com.veteran.planai.domain.plan.application.port.`in`

import com.veteran.planai.domain.plan.application.dto.response.PlanDetailResponse
import com.veteran.planai.domain.plan.application.dto.response.PlanResponse
import com.veteran.planai.global.common.dto.response.BaseResponseData

interface PlanFindUsecase {
    fun findById(id: Long):BaseResponseData<PlanDetailResponse>
    fun findByUserId(): BaseResponseData<List<PlanResponse>>
}