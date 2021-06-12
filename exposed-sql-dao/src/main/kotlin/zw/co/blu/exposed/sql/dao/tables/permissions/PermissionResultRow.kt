package zw.co.blu.exposed.sql.dao.tables.permissions

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import zw.co.blu.domain.model.abilities.Ability
import zw.co.blu.exposed.sql.dao.mapper.permissions.PermissionStatusMapper
import zw.co.blu.exposed.sql.dao.model.permissions.PermissionModel
import zw.co.blu.exposed.sql.dao.tables.abilities.toAbility
import zw.co.blu.exposed.sql.dao.tables.permissionsAbilities.PermissionAbilitiesTable

fun ResultRow.toPermissionModel(): PermissionModel = PermissionModel(
        name = this[PermissionsTable.name],
        permissionStatus = PermissionStatusMapper().fromValue(this[PermissionsTable.permissionStatus]),
        abilities = toAbilities(this[PermissionsTable.id]),
)

fun toAbilities(id: Int): List<Ability> = transaction {
    PermissionAbilitiesTable.select { PermissionAbilitiesTable.permission_id eq id }.map {
        it.toAbility()
    }
}