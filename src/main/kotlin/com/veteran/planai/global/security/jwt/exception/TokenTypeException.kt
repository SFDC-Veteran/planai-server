package com.veteran.planai.global.security.jwt.exception

import com.veteran.planai.global.exception.BusinessException
import com.veteran.planai.global.security.jwt.exception.error.JwtTokenError

object TokenTypeException : BusinessException(JwtTokenError.JWT_TOKEN_ERROR) {

    private fun readResolve(): Any = TokenTypeException

    val EXCEPTION: TokenTypeException = TokenTypeException

}