package zw.co.blu.exposed.sql.dao.table.permissions

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import zw.co.blu.data.model.permissions.PermissionEntity
import zw.co.blu.exposed.sql.dao.mapper.permissions.PermissionStatusMapper
import zw.co.blu.exposed.sql.dao.table.permissionsPrivileges.PermissionPrivilegesTable
import zw.co.blu.exposed.sql.dao.table.privileges.PrivilegesEntity

object PermissionsTable : IntIdTable() {
    val name = varchar("name", 255)
    val permissionStatus = integer("permission_status")

    override val primaryKey = PrimaryKey(PermissionsTable.id, name = "PK_Permissions_ID")
}

class PermissionsEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PermissionsEntity>(PermissionsTable)

    var name by PermissionsTable.name
    var permissionStatus by PermissionsTable.permissionStatus
    var privileges by PrivilegesEntity via PermissionPrivilegesTable

    fun toDataEntity() = PermissionEntity(
            id = this.id.toString(),
            name = this.name,
            permissionStatus = PermissionStatusMapper().fromValue(this.permissionStatus),
            privileges = this.privileges.map { it.fromValue() }
    )
}