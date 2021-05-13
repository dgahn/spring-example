package me.dgahn.user

import java.time.LocalDateTime

class User(
    var id: Int? = null,
    val name: String,
    val joinDate: LocalDateTime
)