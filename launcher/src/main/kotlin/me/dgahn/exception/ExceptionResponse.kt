package me.dgahn.exception

import java.time.LocalDateTime

class ExceptionResponse(
    val time: LocalDateTime,
    val message: String,
    val details: String
)