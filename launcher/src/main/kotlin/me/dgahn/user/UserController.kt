package me.dgahn.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
class UserController(
    private val repository: UserRepository
) {

    @GetMapping("/users")
    fun findAll(): List<User> = repository.findAll()

    @GetMapping("/users/{id}")
    fun findById(@PathVariable id: Int) = repository.findOne(id) ?: throw UserNotFoundException("ID[$id] not found")

    @PostMapping("/users")
    fun create(@RequestBody user: User): ResponseEntity<User> {
        val savedUser = repository.save(user)

        // Post를 통해서 생성된 결과를 사용자가 조회해서 알 수 있게 header에 정보를 보내준다.
        val location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.id)
            .toUri()

        return ResponseEntity.created(location).build()
    }

    @DeleteMapping("/users/{id}")
    fun delete(@PathVariable id: Int) {
        if (!repository.deleteById(id)) {
            throw UserNotFoundException("ID[$id] not found")
        }
    }

}