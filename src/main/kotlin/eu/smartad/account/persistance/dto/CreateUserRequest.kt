package eu.smartad.account.persistance.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CreateUserRequest @JsonCreator constructor(
    @field:NotNull(message = "Username cannot be null")
    @field:Size(min = 3, max = 32, message = "Username should be 2 chars min and 32 chars max")
    var username: String,
    @field:JsonProperty("first_name")
    @field:NotNull(message = "First name cannot be null")
    @field:Size(min = 3, max = 32, message = "First name should be 2 chars min and 32 chars max")
    var firstName: String,
    @field:NotNull(message = "Surname cannot be null")
    @field:Size(min = 3, max = 32, message = "Surname name should be 2 chars min and 32 chars max")
    var surname: String,
    @field:NotNull(message = "Password cannot be null")
    @field:Size(min = 3, max = 32, message = "Password name should be 2 chars min and 32 chars max")
    var password: String,
    @field:NotNull(message = "Email cannot be null")
    @field:Email
    var email: String
)