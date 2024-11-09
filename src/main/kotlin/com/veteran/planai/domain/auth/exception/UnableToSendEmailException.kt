package com.veteran.planai.domain.auth.exception

import com.veteran.planai.domain.auth.exception.error.EmailError
import com.veteran.planai.global.exception.BusinessException

object UnableToSendEmailException: BusinessException(EmailError.UNABLE_TO_SEND) {

    private fun readResolve(): Any = UnableToSendEmailException

    val EXCEPTION: UnableToSendEmailException = UnableToSendEmailException

}