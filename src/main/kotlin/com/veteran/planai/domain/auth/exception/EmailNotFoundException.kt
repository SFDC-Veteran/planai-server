package com.veteran.planai.domain.auth.exception

import com.veteran.planai.domain.auth.exception.error.EmailError
import com.veteran.planai.global.exception.BusinessException

object EmailNotFoundException: BusinessException(EmailError.EMAIL_NOT_FOUND) {
    private fun readResolve(): Any = EmailNotFoundException
    val EXCEPTION: EmailNotFoundException = EmailNotFoundException
}