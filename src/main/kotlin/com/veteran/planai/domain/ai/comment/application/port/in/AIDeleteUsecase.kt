package com.veteran.planai.domain.ai.comment.application.port.`in`

import com.veteran.planai.global.common.dto.response.BaseResponse

interface AIDeleteUsecase {
    fun deleteById(id: String):BaseResponse
    fun deleteByChatId(chatId: String):BaseResponse
}