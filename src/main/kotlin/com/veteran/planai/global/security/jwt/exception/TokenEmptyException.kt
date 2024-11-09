package com.veteran.planai.global.security.jwt.exception

import com.veteran.planai.global.exception.BusinessException
import com.veteran.planai.global.security.jwt.exception.error.JwtTokenError

object TokenEmptyException: BusinessException(JwtTokenError.JWT_EMPTY_EXCEPTION) {
    private fun readResolve():Any = TokenEmptyException
    val EXCEPTION: TokenEmptyException = TokenEmptyException
}