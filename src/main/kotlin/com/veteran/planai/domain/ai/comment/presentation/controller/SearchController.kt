package com.veteran.planai.domain.ai.comment.presentation.controller

import com.veteran.planai.domain.ai.comment.application.dto.enums.FocusMode
import com.veteran.planai.domain.ai.comment.application.dto.response.QnAResponse
import com.veteran.planai.domain.ai.comment.application.dto.response.SearchResponse
import com.veteran.planai.domain.ai.comment.service.AISearchService
import com.veteran.planai.global.common.dto.response.BaseResponseData
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/search")
@RestController
class SearchController(private val aISearchService: AISearchService) {

    @GetMapping("/web")
    fun searchWeb(@RequestBody query: String, @RequestParam planId: Long, chatId: String?): BaseResponseData<QnAResponse> {
        return aISearchService.search(query,FocusMode.WEB, planId, chatId)
    }

    @GetMapping("/reddit")
    fun searchReddit(@RequestBody query: String, @RequestParam planId: Long, chatId: String?): BaseResponseData<QnAResponse> {
        return aISearchService.search(query,FocusMode.REDDIT, planId, chatId)
    }

    @GetMapping("/youtube")
    fun searchYoutube(@RequestBody query: String, @RequestParam planId: Long, chatId: String?): BaseResponseData<QnAResponse> {
        return aISearchService.search(query,FocusMode.YOUTUBE, planId, chatId)
    }

    @GetMapping("/academic")
    fun searchAcademic(@RequestBody query: String, @RequestParam planId: Long, chatId: String?): BaseResponseData<QnAResponse> {
        return aISearchService.search(query,FocusMode.ACADEMIC, planId, chatId)
    }

    @GetMapping("/wolfram")
    fun searchWolfram(@RequestBody query: String, @RequestParam planId: Long, chatId: String?): BaseResponseData<QnAResponse> {
        return aISearchService.search(query,FocusMode.WOLFRAM, planId, chatId)
    }

    @GetMapping("/write")
    fun searchWrite(@RequestBody query: String, @RequestParam planId: Long, chatId: String?): BaseResponseData<QnAResponse> {
        return aISearchService.search(query,FocusMode.WRITE, planId, chatId)
    }

}