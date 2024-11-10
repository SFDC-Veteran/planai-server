package com.veteran.planai.domain.plan.presentation

import com.veteran.planai.domain.plan.application.dto.request.PlanRequest
import com.veteran.planai.domain.plan.application.port.`in`.PlanSaveUsecase
import com.veteran.planai.global.common.dto.response.BaseResponseData
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/plan")
@RestController
class PlanSaveController(
    private val planSaveUsecase: PlanSaveUsecase
) {
    @PostMapping("/save")
    fun execute(@RequestBody request: PlanRequest): BaseResponseData<Long>{
        return planSaveUsecase.save(request)
    }
}