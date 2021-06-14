package zw.co.blu.exposed.sql.dao.table.rolePermissions

import org.jetbrains.exposed.sql.Table
import zw.co.blu.exposed.sql.dao.table.permissions.PermissionsTable
import zw.co.blu.exposed.sql.dao.table.roles.RolesTable


object RolePermissionsTable : Table() {
    val role = reference("role", RolesTable)
    val permission = reference("permission", PermissionsTable)

    override val primaryKey = PrimaryKey(role, permission, name = "PK_RolePermissions_swf_act") // PK_PermissionPrivileges_swf_act is optional here
}