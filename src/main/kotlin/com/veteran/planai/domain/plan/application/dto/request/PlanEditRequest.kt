package com.veteran.planai.domain.plan.application.dto.request

import com.fasterxml.jackson.annotation.JsonProperty

data class PlanEditRequest(
    @JsonProperty("planId")
    val planId: Long,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("description")
    val description: String,
)
