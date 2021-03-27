package eu.smartad.account.persistance.domain

import javax.persistence.*

@Entity
@Table(name = "roles")
data class RoleEntity(
    val roleDesc: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Int = 0
}