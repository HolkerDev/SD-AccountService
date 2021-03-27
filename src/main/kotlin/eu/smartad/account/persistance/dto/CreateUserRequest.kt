package eu.smartad.account.persistance.dto

data class CreateUserRequest(
    var username: String,
    var firstName: String,
    var surname: String
)