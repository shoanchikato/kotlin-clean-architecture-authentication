package zw.co.blu.exposed.sql.dao.table.rolesPermissions

//import org.jetbrains.exposed.sql.Table
//import zw.co.blu.exposed.sql.dao.table.permissions.PermissionsTable
//import zw.co.blu.exposed.sql.dao.table.roles.RolesTable

//object RolesPermissionsTable : Table() {
//    val id = integer("id").autoIncrement()
//    val role_id = (integer("role_id") references RolesTable.id).nullable()
//    val permission_id = (integer("permission_id") references PermissionsTable.id).nullable()
//
//    override val primaryKey = PrimaryKey(id, name = "PK_Roles_Permissions_ID")
//}