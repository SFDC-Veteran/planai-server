package com.veteran.planai.global.security.jwt.exception

import com.veteran.planai.global.exception.BusinessException
import com.veteran.planai.global.security.jwt.exception.error.JwtTokenError

object TokenExpiredException : BusinessException(JwtTokenError.JWT_EXPIRED) {

    private fun readResolve(): Any = TokenExpiredException

    val EXCEPTION: TokenExpiredException = TokenExpiredException

}