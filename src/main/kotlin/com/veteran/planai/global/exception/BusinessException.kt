package com.veteran.planai.global.exception

import com.veteran.planai.global.exception.error.ErrorProperty

open class BusinessException(val error: ErrorProperty) : RuntimeException() {

}