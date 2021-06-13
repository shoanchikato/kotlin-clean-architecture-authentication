package zw.co.blu.exposed.sql.dao.table.permissions

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import zw.co.blu.exposed.sql.dao.mapper.permissions.PermissionStatusMapper
import zw.co.blu.exposed.sql.dao.model.permissions.PermissionModel
import zw.co.blu.exposed.sql.dao.table.abilities.AbilitiesEntity
import zw.co.blu.exposed.sql.dao.table.permissionsAbilities.PermissionAbilitiesTable

object PermissionsTable : IntIdTable() {
    val name = varchar("name", 255)
    val permissionStatus = integer("permission_status")

    override val primaryKey = PrimaryKey(PermissionsTable.id, name = "PK_Permissions_ID")
}

class PermissionsEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PermissionsEntity>(PermissionsTable)

    var name by PermissionsTable.name
    var permissionStatus by PermissionsTable.permissionStatus

    var abilities by AbilitiesEntity via PermissionAbilitiesTable

    fun toModel() = PermissionModel(
            name = this.name,
            permissionStatus = PermissionStatusMapper().fromValue(this.permissionStatus),
            abilities = this.abilities.map { it.toModel() }
    )
}