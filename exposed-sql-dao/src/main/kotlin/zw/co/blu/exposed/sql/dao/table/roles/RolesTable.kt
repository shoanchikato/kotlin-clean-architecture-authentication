package zw.co.blu.exposed.sql.dao.table.roles

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import zw.co.blu.data.model.roles.RoleEntity
import zw.co.blu.exposed.sql.dao.mapper.roles.RoleStatusMapper
import zw.co.blu.exposed.sql.dao.table.permissions.PermissionsEntity
import zw.co.blu.exposed.sql.dao.table.rolePermissions.RolePermissionsTable

object RolesTable : IntIdTable() {
    val name = varchar("name", 255)
    val roleStatus = integer("roleStatus")

    override val primaryKey = PrimaryKey(id, name = "PK_Roles_ID")
}

class RolesEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RolesEntity>(RolesTable)

    var name by RolesTable.name
    var roleStatus by RolesTable.roleStatus
    var permissions by PermissionsEntity via RolePermissionsTable

    fun toDataEntity() = RoleEntity(
            id = this.id.toString(),
            name = this.name,
            roleStatus = RoleStatusMapper().fromValue(this.roleStatus),
            permissions = this.permissions.map { it.toDataEntity() }
    )
}