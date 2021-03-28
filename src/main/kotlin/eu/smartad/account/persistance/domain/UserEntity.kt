package eu.smartad.account.persistance.domain

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
    val password: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @Column(name = "id")
    var id: UUID = UUID.randomUUID()

    @OneToMany(fetch = FetchType.LAZY)
    var userRoles: List<UserRolesEntity> = arrayListOf()

    fun getRoles() = userRoles.map { it.role.roleDesc }.toSet()
}