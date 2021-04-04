package eu.smartad.account.persistance.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class CreateUserRequest @JsonCreator constructor(
    var username: String,
    @field:JsonProperty("first_name")
    var firstName: String,
    var surname: String,
    var password: String
)