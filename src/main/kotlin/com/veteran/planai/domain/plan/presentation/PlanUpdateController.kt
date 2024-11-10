package com.veteran.planai.domain.plan.presentation

import com.veteran.planai.domain.plan.application.dto.request.PlanEditRequest
import com.veteran.planai.domain.plan.application.port.`in`.PlanUpdateUsecase
import com.veteran.planai.global.common.dto.response.BaseResponse
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/plan")
@RestController
class PlanUpdateController(
    private val planUpdateUsecase: PlanUpdateUsecase
) {
    @PatchMapping("/update")
    fun update(@RequestBody request: PlanEditRequest): BaseResponse{
        return planUpdateUsecase.update(request)
    }
}