package com.veteran.planai.domain.ai.comment.application.dto.request

data class SearchRequest(
    val chatModel: ChatModel,
    val embeddingModel: EmbeddingModel,
    val optimizationMode: String,
    val focusMode: String,
    val query: String,
    val history: List<List<String>>? = null
)

data class ChatModel(
    val provider: String,
    val model: String
)

data class EmbeddingModel(
    val provider: String,
    val model: String
)
