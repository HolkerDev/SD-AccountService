package eu.smartad.account.controllers

import eu.smartad.account.persistance.dto.CreateUserRequest
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    private val log = LoggerFactory.getLogger(UserController::class.java)

    @GetMapping("/test")
    fun check(): ResponseEntity<String> {
        return ResponseEntity.ok("Test is fine. Account endpoint is working")
    }

    @PostMapping("/")
    fun createUser(requestForm: CreateUserRequest): ResponseEntity<*> {
        //TODO: Implement registration
        return ResponseEntity.ok("FINE")
    }
}