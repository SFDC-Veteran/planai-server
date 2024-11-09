package com.veteran.planai.domain.auth.exception

import com.veteran.planai.domain.auth.exception.error.EmailError
import com.veteran.planai.global.exception.BusinessException

object EmailExistsException: BusinessException(EmailError.EMAIL_CONFLICT) {
    private fun readResolve(): Any = EmailExistsException

    val EXCEPTION: EmailExistsException = EmailExistsException
}