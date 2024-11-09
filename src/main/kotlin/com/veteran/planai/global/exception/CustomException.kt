package com.veteran.planai.global.exception

import com.veteran.planai.global.exception.error.ErrorProperty

class CustomException(
    val errorProperty: ErrorProperty
): RuntimeException()