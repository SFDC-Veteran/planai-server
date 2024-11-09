package com.veteran.planai.domain.user.exception

import com.veteran.planai.domain.user.exception.error.UserError
import com.veteran.planai.global.exception.BusinessException

object UserNotFoundException : BusinessException(UserError.USER_NOT_FOUND) {

    private fun readResolve(): Any = UserNotFoundException

    val EXCEPTION: UserNotFoundException = UserNotFoundException

}