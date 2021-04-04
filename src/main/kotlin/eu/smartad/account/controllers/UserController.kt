package eu.smartad.account.controllers

import eu.smartad.account.persistance.dto.CreateUserRequest
import eu.smartad.account.services.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UserController @Autowired constructor(private val userService: UserService) {
    private val log = LoggerFactory.getLogger(UserController::class.java)

    @GetMapping("/test")
    fun check(): ResponseEntity<String> {
        return ResponseEntity.ok("Test is fine. Account endpoint is working")
    }

    @PostMapping("/")
    fun createUser(requestForm: CreateUserRequest): ResponseEntity<*> {
        val userDto = userService.createUser(requestForm)
        return ResponseEntity.ok(userDto)
    }

    @GetMapping("/{userId}")
    fun findUserById(@PathVariable userId: String): ResponseEntity<*> {
        val userDto = userService.findUserDto(UUID.fromString(userId))
        return ResponseEntity.ok(userDto)
    }

    @GetMapping("/{username}")
    fun findUserByUsername(@PathVariable username: String): ResponseEntity<*> {
        val userDto = userService.findUserDto(username)
        return ResponseEntity.ok(userDto)
    }
}