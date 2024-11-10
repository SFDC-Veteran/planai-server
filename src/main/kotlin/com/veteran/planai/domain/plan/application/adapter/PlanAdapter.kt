package com.veteran.planai.domain.plan.application.adapter

import com.veteran.planai.domain.plan.application.port.out.PlanDeletePort
import com.veteran.planai.domain.plan.application.port.out.PlanFindPort
import com.veteran.planai.domain.plan.application.port.out.PlanSavePort
import com.veteran.planai.domain.plan.domain.PlanEntity
import com.veteran.planai.domain.plan.domain.repository.PlanRepository
import com.veteran.planai.domain.plan.exception.PlanError
import com.veteran.planai.global.exception.CustomException
import org.springframework.stereotype.Component

@Component
class PlanAdapter(
    private val repository: PlanRepository
) : PlanSavePort, PlanDeletePort, PlanFindPort {

    override fun save(entity: PlanEntity): PlanEntity {
        return repository.save(entity)
    }

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }

    override fun findById(id: Long): PlanEntity {
        return repository.findById(id).orElseThrow { throw CustomException(PlanError.PLAN_NOT_FOUND) }
    }

    override fun findByUserId(userId: String): List<PlanEntity>? {
        return repository.findByUserId(userId).orEmpty()
    }

}