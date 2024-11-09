package com.veteran.planai.domain.auth.exception

import com.veteran.planai.domain.auth.exception.error.EmailError
import com.veteran.planai.global.exception.BusinessException

object EmailNotVerifiedException: BusinessException(EmailError.EMAIL_NOT_VERIFY) {
    private fun readResolve():Any = EmailNotVerifiedException

    val EXCEPTION: EmailNotVerifiedException = EmailNotVerifiedException
}