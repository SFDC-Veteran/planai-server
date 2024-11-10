package com.veteran.planai.domain.ai.comment.service

import com.veteran.planai.domain.ai.comment.application.dto.enums.FocusMode
import com.veteran.planai.domain.ai.comment.application.dto.request.ChatModel
import com.veteran.planai.domain.ai.comment.application.dto.request.EmbeddingModel
import com.veteran.planai.domain.ai.comment.application.dto.request.SearchRequest
import com.veteran.planai.domain.ai.comment.application.dto.response.QnAResponse
import com.veteran.planai.domain.ai.comment.application.dto.response.SearchResponse
import com.veteran.planai.domain.ai.comment.application.port.`in`.AISearchUsecase
import com.veteran.planai.domain.ai.comment.application.port.out.AIFindPort
import com.veteran.planai.domain.ai.comment.application.port.out.AISavePort
import com.veteran.planai.domain.ai.comment.mapper.AIMapper
import com.veteran.planai.global.common.dto.response.BaseResponseData
import com.veteran.planai.global.common.repository.UserSecurity
import org.bson.types.ObjectId
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class AISearchService(
private val restTemplate: RestTemplate,
private val aiMapper: AIMapper,
private val userSecurity: UserSecurity,
private val aiSavePort: AISavePort,
) : AISearchUsecase {

    override fun search(query: String, mode: FocusMode, planId: Long, chatId: String?): BaseResponseData<QnAResponse> {
        val url = "http://localhost:3001/api/search"

        val searchRequest = SearchRequest(
            chatModel = ChatModel(provider = "openai", model = "gpt-4o"),
            embeddingModel = EmbeddingModel(provider = "openai", model = "text-embedding-3-large"),
            optimizationMode = "speed",
            focusMode = mode.value,
            query = query,
            history = null
        )

        // 요청 헤더 설정
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val entity = HttpEntity(searchRequest, headers)

        // API 호출
        try {
            val response = restTemplate.exchange(url, HttpMethod.POST, entity, SearchResponse::class.java).let { aiMapper.toResponse(response = it.body!!, query = query, chatId = chatId) }
            aiSavePort.save(
                aiMapper.toEntity(
                    planId = planId,
                    userId = userSecurity.getUser().id,
                    response = response
                )
            )
            return BaseResponseData.ok(
                message = "답변 생성 성공", data = response
            )
        } catch (e: Exception) {
            throw RuntimeException(e.message, e)
        }
    }

}