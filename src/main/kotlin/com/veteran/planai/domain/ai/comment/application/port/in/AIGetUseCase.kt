package com.veteran.planai.domain.ai.comment.application.port.`in`

import com.veteran.planai.global.common.dto.response.BaseResponseData

interface AIGetUseCase {
    fun findByChatId(chatId: String): BaseResponseData<List<List<String>>>
    fun findByPlanId(planId: Long): BaseResponseData<List<String>>
}