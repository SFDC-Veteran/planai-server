package com.veteran.planai.domain.ai.comment.presentation.controller

import com.veteran.planai.domain.ai.comment.application.dto.response.SearchResponse
import com.veteran.planai.domain.ai.comment.service.AISearchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SearchController(private val aISearchService: AISearchService) {

    @GetMapping("/search")
    fun search(@RequestParam query: String): SearchResponse? {
        return aISearchService.searchPerplexica(query)
    }
}