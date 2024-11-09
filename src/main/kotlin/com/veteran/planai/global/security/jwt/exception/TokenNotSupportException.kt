package com.veteran.planai.global.security.jwt.exception

import com.veteran.planai.global.exception.BusinessException
import com.veteran.planai.global.security.jwt.exception.error.JwtTokenError

object TokenNotSupportException : BusinessException(JwtTokenError.JWT_NOT_SUPPORT) {

    private fun readResolve(): Any = TokenNotSupportException

    val EXCEPTION: TokenNotSupportException = TokenNotSupportException

}