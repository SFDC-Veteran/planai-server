package com.veteran.planai.domain.auth.client.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class SignUpRequest(
    @JsonProperty("email")
    @field:Email(message = "Must be a valid email address")
    val id: String,
    @JsonProperty("name")
    @field:NotBlank(message = "Name must not be blank")
    val name: String,
    @JsonProperty("password")
    @field:NotBlank(message = "Password must not be blank")
    val password: String,
)