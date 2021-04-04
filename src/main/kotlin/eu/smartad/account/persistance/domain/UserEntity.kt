package eu.smartad.account.persistance.domain

import eu.smartad.account.persistance.dto.response.UserDto
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "smart_users")
data class UserEntity(
    @Column(name = "first_name", nullable = false)
    val firstName: String,
    @Column(name = "surname", nullable = false)
    val surname: String,
    @Column(name = "username", nullable = false, unique = true)
    val username: String,
    @Column(name = "password", nullable = false)
    val password: String,
    @Column(name = "email", nullable = false, unique = true)
    var email: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @Column(name = "id")
    var id: UUID = UUID.randomUUID()

    @OneToMany(fetch = FetchType.LAZY)
    var userRoles: List<UserRolesEntity> = arrayListOf()

    @Column(name = "is_verify", nullable = false)
    var isVerify: Boolean = false

    fun getRoles() = userRoles.map { it.role.roleDesc }.toSet()

    fun toDto() = UserDto(this.username, this.firstName, this.surname)
}