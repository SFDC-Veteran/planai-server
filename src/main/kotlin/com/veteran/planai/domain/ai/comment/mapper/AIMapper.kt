package com.veteran.planai.domain.ai.comment.mapper

import com.veteran.planai.domain.ai.comment.application.dto.AIComment
import com.veteran.planai.domain.ai.comment.application.dto.response.QnAResponse
import com.veteran.planai.domain.ai.comment.application.dto.response.SearchResponse
import com.veteran.planai.domain.ai.comment.domain.AIEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class AIMapper {

    fun toEntity(response: QnAResponse, userId: String, planId: Long): AIEntity {
        return AIEntity(
            message = response.message,
            sources = response.sources,
            question = response.question,
            userId = userId,
            planId = planId,
            chatId = response.chatId
        )
    }

    fun toDomain(entity: AIEntity): AIComment {
        return AIComment(
            id = entity.id.toString(),
            message = entity.message,
            sources = entity.sources,
            userId = entity.userId,
            planId = entity.planId,
            question = entity.question,
            chatId = entity.chatId,
        )
    }

    fun toResponse(entity: AIEntity): QnAResponse {
        return QnAResponse(
            question = entity.question,
            message = entity.message,
            sources = entity.sources,
            chatId = entity.chatId,
        )
    }

    fun toResponse(response: SearchResponse, query: String, chatId: String?): QnAResponse {
        return QnAResponse(
            question = query,
            message = response.message,
            sources = response.sources,
            chatId = chatId?: UUID.randomUUID().toString(),
        )
    }

}