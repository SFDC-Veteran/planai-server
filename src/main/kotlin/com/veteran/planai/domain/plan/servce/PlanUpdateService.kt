package com.veteran.planai.domain.plan.servce

import com.veteran.planai.domain.plan.application.dto.request.PlanEditRequest
import com.veteran.planai.domain.plan.application.port.`in`.PlanUpdateUsecase
import com.veteran.planai.domain.plan.application.port.out.PlanFindPort
import com.veteran.planai.domain.plan.application.port.out.PlanSavePort
import com.veteran.planai.domain.plan.mapper.PlanMapper
import com.veteran.planai.global.common.dto.response.BaseResponse
import org.springframework.stereotype.Service

@Service
class PlanUpdateService(
    private val planMapper: PlanMapper,
    private val planSavePort: PlanSavePort,
    private val planFindPort: PlanFindPort,
): PlanUpdateUsecase {

    override fun update(request: PlanEditRequest): BaseResponse {
        val model = planMapper.toDomain(planFindPort.findById(request.planId))
        model.title = request.title
        model.description = request.description
        planSavePort.save(planMapper.toEntity(model))
        return BaseResponse.ok(message = "수정 성공")
    }

}