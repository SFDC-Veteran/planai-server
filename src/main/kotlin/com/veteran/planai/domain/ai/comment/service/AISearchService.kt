package com.veteran.planai.domain.ai.comment.service

import com.veteran.planai.domain.ai.comment.application.dto.request.SearchRequest
import com.veteran.planai.domain.ai.comment.application.dto.response.SearchResponse
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class AISearchService(private val restTemplate: RestTemplate) {

    fun searchPerplexica(query: String): SearchResponse {
        val url = "http://localhost:3001/api/search"

        // 요청 본문 생성
        val searchRequest = SearchRequest(
            optimizationMode = "speed",
            focusMode = "webSearch",
            query = query,
            history = listOf(
                listOf("human", "Hi, how are you?"),
                listOf("assistant", "I am doing well, how can I help you today?")
            )
        )

        // 요청 헤더 설정
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val entity = HttpEntity(searchRequest, headers)

        // API 호출
        return try {
            val response = restTemplate.exchange(url, HttpMethod.POST, entity, SearchResponse::class.java)
            response.body!!
        } catch (e: Exception) {
            throw RuntimeException(e.message, e)
        }
    }
}