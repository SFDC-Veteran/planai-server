package com.veteran.planai.domain.plan.servce

import com.veteran.planai.domain.plan.application.port.`in`.PlanDeleteUsecase
import com.veteran.planai.domain.plan.application.port.out.PlanDeletePort
import com.veteran.planai.domain.plan.application.port.out.PlanFindPort
import com.veteran.planai.domain.plan.exception.PlanError
import com.veteran.planai.global.common.dto.response.BaseResponse
import com.veteran.planai.global.common.repository.UserSecurity
import com.veteran.planai.global.exception.CustomException
import org.springframework.stereotype.Service

@Service
class PlanDeleteService(
    private val planDeletePort: PlanDeletePort,
    private val planFindPort: PlanFindPort,
    private val userSecurity: UserSecurity
): PlanDeleteUsecase {

    override fun deleteById(planId: Long): BaseResponse {
        val entity = planFindPort.findById(planId)
        if(userSecurity.getUser().id == entity.userId) {
            planDeletePort.deleteById(planId)
            return BaseResponse.ok(message = "삭제 성공")
        }
        throw CustomException(PlanError.PLAN_CANNOT_DELETE)
    }

}