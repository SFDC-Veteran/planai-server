package com.veteran.planai.domain.ai.comment.application.port.out

import com.veteran.planai.domain.ai.comment.domain.AIEntity

interface AIFindPort {
    fun findByChatId(chatId: String): List<AIEntity>
    fun findByPlanId(planId: Long): List<String>
}