package me.dgahn.user

import java.time.LocalDateTime

open class User(
    var id: Int? = null,
    var name: String,
    var joinDate: LocalDateTime
) {

    constructor(): this(
        name = "",
        joinDate = LocalDateTime.now()
    )

}