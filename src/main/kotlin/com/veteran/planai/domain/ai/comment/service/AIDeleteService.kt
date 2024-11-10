package com.veteran.planai.domain.ai.comment.service

import com.veteran.planai.domain.ai.comment.application.port.`in`.AIDeleteUsecase
import com.veteran.planai.domain.ai.comment.application.port.out.AIDeletePort
import com.veteran.planai.global.common.dto.response.BaseResponse
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class AIDeleteService(
    private val aiDeletePort: AIDeletePort
): AIDeleteUsecase {
    override fun deleteById(id: String): BaseResponse {
        aiDeletePort.deleteById(ObjectId(id))
        return BaseResponse.ok(message = "삭제 성공")
    }

    override fun deleteByChatId(chatId: String): BaseResponse {
        aiDeletePort.deleteByChatId(chatId)
        return BaseResponse.ok(message = "삭제 성공")
    }
}