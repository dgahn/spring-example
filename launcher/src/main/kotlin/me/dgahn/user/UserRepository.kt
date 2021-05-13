package me.dgahn.user

import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class UserRepository {
    private val users: MutableList<User> = mutableListOf(
        User(1, "Kenneth", LocalDateTime.now()),
        User(2, "Alice", LocalDateTime.now()),
        User(3, "Elena", LocalDateTime.now())
    )

    var usersCount = 3;

    fun findAll() = users

    fun save(user: User): User {
        if(user.id == null) {
            user.id = ++usersCount
        }

        users.add(user)
        return user
    }

    fun findOne(id: Int) = users.find { it.id == id }

    fun deleteById(id: Int) = users.removeIf { it.id == id }

}