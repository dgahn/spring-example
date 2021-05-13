package me.dgahn.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val repository: UserRepository
) {

    @GetMapping("/users")
    fun findAll(): List<User> = repository.findAll()

    @GetMapping("/users/{id}")
    fun findById(@PathVariable id: Int) = repository.findOne(id)

}