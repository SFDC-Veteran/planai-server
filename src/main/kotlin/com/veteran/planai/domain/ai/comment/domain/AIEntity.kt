package com.veteran.planai.domain.ai.comment.domain

import com.veteran.planai.domain.ai.comment.application.dto.model.Source
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "search_responses")
data class AIEntity(
    @Id val id: ObjectId? = null,
    var message: String,
    var sources: List<Source>? = null,
    var question: String,
    var userId: String,
    var planId: Long,
    val chatId: String,
)