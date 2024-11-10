package com.veteran.planai.domain.plan.mapper

import com.veteran.planai.domain.plan.application.dto.model.PlanModel
import com.veteran.planai.domain.plan.application.dto.response.PlanDetailResponse
import com.veteran.planai.domain.plan.application.dto.response.PlanResponse
import com.veteran.planai.domain.plan.domain.PlanEntity
import org.springframework.stereotype.Component

@Component
class PlanMapper {

    fun toEntity(model: PlanModel) : PlanEntity{
        return PlanEntity(
            id = model.id,
            title = model.title,
            description = model.description,
            userId = model.userId,
        )
    }

    fun toDomain(entity: PlanEntity) : PlanModel{
        return PlanModel(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            userId = entity.userId,
        )
    }

    fun toDetailResponse(entity: PlanEntity) : PlanDetailResponse {
        return PlanDetailResponse(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            userId = entity.userId,
        )
    }

    fun toResponse(entity: PlanEntity) : PlanResponse {
        return PlanResponse(
            id = entity.id,
            title = entity.title,
        )
    }

}