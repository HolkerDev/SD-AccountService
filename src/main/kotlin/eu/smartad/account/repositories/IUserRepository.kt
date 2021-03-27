package eu.smartad.account.repositories

import eu.smartad.account.persistance.domain.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface IUserRepository : JpaRepository<UserEntity, UUID> {
    fun findByUsername(username: String): UserEntity?
}