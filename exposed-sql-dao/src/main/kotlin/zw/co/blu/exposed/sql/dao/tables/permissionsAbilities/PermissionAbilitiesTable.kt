package zw.co.blu.exposed.sql.dao.tables.permissionsAbilities

import org.jetbrains.exposed.sql.Table
import zw.co.blu.exposed.sql.dao.tables.abilities.AbilitiesTable
import zw.co.blu.exposed.sql.dao.tables.permissions.PermissionsTable

object PermissionAbilitiesTable : Table() {
    val id = integer("id").autoIncrement()
    val permission_id = integer("permission_id")
    val abilities_id = integer("abilities_id")

    override val primaryKey = PrimaryKey(id, name = "PK_Permissions_Abilities_ID")
}