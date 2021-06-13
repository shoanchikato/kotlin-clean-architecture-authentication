package zw.co.blu.exposed.sql.dao.table.permissionsAbilities

import org.jetbrains.exposed.sql.Table
import zw.co.blu.exposed.sql.dao.table.abilities.AbilitiesTable
import zw.co.blu.exposed.sql.dao.table.permissions.PermissionsTable

object PermissionAbilitiesTable : Table() {
    val permission = reference("permission", PermissionsTable)
    val ability = reference("ability", AbilitiesTable)

    override val primaryKey = PrimaryKey(permission, ability, name = "PK_PermissionAbilities_swf_act") // PK_PermissionAbilities_swf_act is optional here
}