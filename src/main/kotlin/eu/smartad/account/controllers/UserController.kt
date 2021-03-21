package eu.smartad.account.controllers

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    private val log = LoggerFactory.getLogger(UserController::class.java)

    fun getUsers(): ResponseEntity<*> {
        TODO("")
    }
}