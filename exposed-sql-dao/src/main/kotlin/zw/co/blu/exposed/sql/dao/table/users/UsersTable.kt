package zw.co.blu.exposed.sql.dao.table.users

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import zw.co.blu.data.model.users.UserEntity
import zw.co.blu.exposed.sql.dao.mapper.users.UserStatusMapper
import zw.co.blu.exposed.sql.dao.table.roles.RolesEntity
import zw.co.blu.exposed.sql.dao.table.roles.RolesTable

object UsersTable : IntIdTable() {
    val username = varchar("username", 255)
    val email = varchar("email", 255)
    val userStatus = integer("user_status")
    val role = reference("role", RolesTable)

    override val primaryKey = PrimaryKey(id, name = "PK_Users_ID")
}

class UsersEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UsersEntity>(UsersTable)

    var username by UsersTable.username
    var email by UsersTable.email
    var userStatus by UsersTable.userStatus
    var role by RolesEntity referencedOn UsersTable.role

    fun toDataEntity() = UserEntity(
            id = this.id.toString(),
            username = this.username,
            email = this.email,
            userStatus = UserStatusMapper().fromValue(this.userStatus),
            role = this.role.toDataEntity(),
    )
}