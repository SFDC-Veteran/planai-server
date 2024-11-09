package com.veteran.planai.global.security.jwt.exception

import com.veteran.planai.global.exception.BusinessException
import com.veteran.planai.global.security.jwt.exception.error.JwtTokenError

object TokenUnKnownException: BusinessException(JwtTokenError.JWT_UNKNOWN_EXCEPTION) {
    private fun readResolve(): Any = TokenUnKnownException
    val EXCEPTION: TokenUnKnownException = TokenUnKnownException
}