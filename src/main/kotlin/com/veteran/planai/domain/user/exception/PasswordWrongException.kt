package com.veteran.planai.domain.user.exception

import com.veteran.planai.domain.user.exception.error.UserError
import com.veteran.planai.global.exception.BusinessException

object PasswordWrongException : BusinessException(UserError.PASSWORD_WRONG) {

    private fun readResolve(): Any = PasswordWrongException

    val EXCEPTION: PasswordWrongException = PasswordWrongException

}