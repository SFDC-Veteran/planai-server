package com.veteran.planai.domain.ai.comment.application.port.out

import com.veteran.planai.domain.ai.comment.domain.AIEntity
import org.bson.types.ObjectId

interface AIFindPort {
    fun findByUserId(userId: String): List<AIEntity>
    fun findByChatId(chatId: ObjectId): List<AIEntity>
    fun findByPlanId(planId: Long): List<AIEntity>
}