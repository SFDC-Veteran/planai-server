package com.veteran.planai.domain.plan.presentation

import com.veteran.planai.domain.plan.application.dto.response.PlanDetailResponse
import com.veteran.planai.domain.plan.application.dto.response.PlanResponse
import com.veteran.planai.domain.plan.application.port.`in`.PlanFindUsecase
import com.veteran.planai.global.common.dto.response.BaseResponseData
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/plan")
@RestController
class PlanGetController(
    private val planFindUsecase: PlanFindUsecase
) {

    @GetMapping("/single/{id}")
    fun getSingle(@PathVariable id: Long): BaseResponseData<PlanDetailResponse>{
        return planFindUsecase.findById(id)
    }

    @GetMapping("/all")
    fun getAll(): BaseResponseData<List<PlanResponse>>{
        return planFindUsecase.findByUserId()
    }

}