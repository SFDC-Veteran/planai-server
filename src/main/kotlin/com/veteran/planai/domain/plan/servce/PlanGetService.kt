package com.veteran.planai.domain.plan.servce

import com.veteran.planai.domain.plan.application.dto.response.PlanDetailResponse
import com.veteran.planai.domain.plan.application.dto.response.PlanResponse
import com.veteran.planai.domain.plan.application.port.`in`.PlanFindUsecase
import com.veteran.planai.domain.plan.application.port.out.PlanFindPort
import com.veteran.planai.domain.plan.exception.PlanError
import com.veteran.planai.domain.plan.mapper.PlanMapper
import com.veteran.planai.global.common.dto.response.BaseResponseData
import com.veteran.planai.global.common.repository.UserSecurity
import com.veteran.planai.global.exception.CustomException
import org.springframework.stereotype.Service

@Service
class PlanGetService(
    private val planFindPort: PlanFindPort,
    private val planMapper: PlanMapper,
    private val userSecurity: UserSecurity
) : PlanFindUsecase {

    override fun findById(id: Long): BaseResponseData<PlanDetailResponse> {
        val response = planFindPort.findById(id).let { plan -> planMapper.toDetailResponse(plan) }
        return BaseResponseData.ok(
            message = "조회 성공",
            data = response
        )
    }

    override fun findByUserId(): BaseResponseData<List<PlanResponse>> {
        val userId = userSecurity.getUser().id
        val response = planFindPort.findByUserId(userId)?.map { planResponse -> planMapper.toResponse(planResponse) }
        if (response == null) throw CustomException(PlanError.PLAN_NOT_FOUND)
        return BaseResponseData.ok(
            message = "조회 성공",
            data = response
        )
    }

}