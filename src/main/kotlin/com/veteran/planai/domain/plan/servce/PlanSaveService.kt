package com.veteran.planai.domain.plan.servce

import com.veteran.planai.domain.plan.application.dto.model.PlanModel
import com.veteran.planai.domain.plan.application.dto.request.PlanRequest
import com.veteran.planai.domain.plan.application.port.`in`.PlanSaveUsecase
import com.veteran.planai.domain.plan.application.port.out.PlanSavePort
import com.veteran.planai.domain.plan.mapper.PlanMapper
import com.veteran.planai.global.common.dto.response.BaseResponse
import com.veteran.planai.global.common.dto.response.BaseResponseData
import com.veteran.planai.global.common.repository.UserSecurity
import org.springframework.stereotype.Service

@Service
class PlanSaveService(
    private val userSecurity: UserSecurity,
    private val planSavePort: PlanSavePort,
    private val planMapper: PlanMapper
): PlanSaveUsecase {

    override fun save(request: PlanRequest): BaseResponseData<Long> {
        val model = PlanModel(
            id = null,
            title = request.title,
            description = request.description,
            userId = userSecurity.getUser().id
        )
        val entity = planSavePort.save(planMapper.toEntity(model))
        return BaseResponseData.ok(message = "저장 완료", data = entity.id!!)
    }

}