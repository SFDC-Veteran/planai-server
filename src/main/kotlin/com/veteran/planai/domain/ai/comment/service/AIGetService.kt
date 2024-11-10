package com.veteran.planai.domain.ai.comment.service

import com.veteran.planai.domain.ai.comment.application.port.`in`.AIGetUseCase
import com.veteran.planai.domain.ai.comment.application.port.out.AIFindPort
import com.veteran.planai.global.common.dto.response.BaseResponseData
import org.springframework.stereotype.Service

@Service
class AIGetService(
    private val aiFindPort: AIFindPort
) : AIGetUseCase {

    fun setList(chatId: String): List<List<String>> {
        return aiFindPort.findByChatId(chatId).map { aiResponse ->
            val human = listOf("human", aiResponse.question)  // "human"과 question
            val assistant = listOf(
                "assistant", "${aiResponse.message} ${aiResponse.sources?.joinToString() ?: ""}"
            )  // "assistant"와 message + sources 합침
            listOf(human, assistant)  // 두 리스트를 합쳐서 반환
        }.flatten()  // 중첩된 리스트를 펼쳐서 반환
    }

    override fun findByChatId(chatId: String): BaseResponseData<List<List<String>>> {
        return BaseResponseData.ok(message = "조회 성공", data = setList(chatId))
    }

    override fun findByPlanId(planId: Long): BaseResponseData<List<String>> {
        return BaseResponseData.ok(message = "조회 성공", data = aiFindPort.findByPlanId(planId))
    }

}