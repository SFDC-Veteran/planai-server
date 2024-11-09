package com.veteran.planai.domain.ai.comment.mapper

import com.veteran.planai.domain.ai.comment.application.dto.AIComment
import com.veteran.planai.domain.ai.comment.application.dto.response.SearchResponse
import com.veteran.planai.domain.ai.comment.domain.AIEntity
import org.bson.types.ObjectId
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class AIMapper {

    fun toEntity(chatId: String?,response: SearchResponse, userId: String, planId: Long): AIEntity {
        return AIEntity(
            id = ObjectId(UUID.randomUUID().toString()),
            message = response.message,
            sources = response.sources,
            userId = userId,
            planId = planId,
            chatId = ObjectId(chatId?:UUID.randomUUID().toString()),
        )
    }

    fun toDomain(entity: AIEntity): AIComment {
        return AIComment(
            id = entity.id.toString(),
            message = entity.message,
            sources = entity.sources,
            userId = entity.userId,
            planId = entity.planId,
            chatId = entity.chatId.toString(),
        )
    }

    fun toResponse(entity: AIEntity): SearchResponse {
        return SearchResponse(
            message = entity.message,
            sources = entity.sources,
        )
    }

}