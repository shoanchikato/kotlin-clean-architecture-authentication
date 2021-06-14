package zw.co.blu.exposed.sql.dao.table.permissionsPrivileges

import org.jetbrains.exposed.sql.Table
import zw.co.blu.exposed.sql.dao.table.permissions.PermissionsTable
import zw.co.blu.exposed.sql.dao.table.privileges.PrivilegesTable

object PermissionPrivilegesTable : Table() {
    val permission = reference("permission", PermissionsTable)
    val privilege = reference("privilege", PrivilegesTable)

    override val primaryKey = PrimaryKey(permission, privilege, name = "PK_PermissionPrivileges_swf_act") // PK_PermissionPrivileges_swf_act is optional here
}