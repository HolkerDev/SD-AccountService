package eu.smartad.account.services

import eu.smartad.account.persistance.domain.UserEntity
import eu.smartad.account.persistance.dto.CreateUserRequest
import eu.smartad.account.persistance.dto.response.UserDto
import eu.smartad.account.repositories.IUserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService @Autowired constructor(private val userRepo: IUserRepository) {
    private val log = LoggerFactory.getLogger(UserService::class.java)

    fun findUserDto(userId: UUID): UserDto {
        val user = userRepo.findById(userId).orElseThrow {
            log.error("User with id: $userId is not present id db")
            throw Exception("User not found for userId: $userId")
        }
        return user.toDto()
    }

    fun findUserDto(username: String): UserDto {
        val user = userRepo.findByUsername(username).orElseThrow {
            log.error("User with username: $username is not present in db")
            throw Exception("User not found for username: $username")
        }
        return user.toDto()
    }

    fun createUser(userForm: CreateUserRequest): UserDto {
        val newUser =
            UserEntity(userForm.firstName, userForm.surname, userForm.username, userForm.password, userForm.email)
        //TODO: add mail verification
        val user = userRepo.save(newUser)
        return user.toDto()
    }
}