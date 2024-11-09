package com.veteran.planai.domain.auth.client.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class SignInRequest(
    @JsonProperty("email")
    @field:Email(message = "Must be a valid email address")
    val id: String,
    @JsonProperty("password")
    @field:NotBlank(message = "Password must not be blank")
    val password: String
)