package eu.smartad.account.persistance.domain

import javax.persistence.*

@Entity(name = "user_roles")
data class UserRolesEntity(
    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: UserEntity,
    @ManyToOne
    @JoinColumn(name = "role_id")
    var role: RoleEntity
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long = 0L
}