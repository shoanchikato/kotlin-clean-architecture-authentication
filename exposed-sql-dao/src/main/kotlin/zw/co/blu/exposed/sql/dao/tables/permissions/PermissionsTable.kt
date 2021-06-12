package zw.co.blu.exposed.sql.dao.tables.permissions

import org.jetbrains.exposed.sql.Table
import zw.co.blu.exposed.sql.dao.tables.permissionsAbilities.PermissionAbilitiesTable

object PermissionsTable : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 255)
    val permissionStatus = integer("permission_status")

    override val primaryKey = PrimaryKey(id, name = "PK_Roles_ID")
}

//data class PermissionModel(
//        val name: String,
//        val permissionStatus: PermissionStatus,
//        val abilities: List<Ability>,
//)