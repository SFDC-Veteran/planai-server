package com.veteran.planai.domain.user.exception

import com.veteran.planai.domain.user.exception.error.UserError
import com.veteran.planai.global.exception.BusinessException

object UserExistException : BusinessException(UserError.USER_EXIST) {

    private fun readResolve(): Any = UserExistException

    val EXCEPTION: UserExistException = UserExistException

}