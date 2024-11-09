package com.veteran.planai.global.security.jwt.exception

import com.veteran.planai.global.exception.BusinessException
import com.veteran.planai.global.security.jwt.exception.error.JwtTokenError

object TokenSignatureException : BusinessException(JwtTokenError.JWT_TOKEN_SIGNATURE_ERROR) {
    private fun readResolve(): Any  = TokenSignatureException
    val EXCEPTION : TokenSignatureException = TokenSignatureException
}