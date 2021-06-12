package zw.co.blu.exposed.sql.dao.tables.roles

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import zw.co.blu.exposed.sql.dao.mapper.roles.RoleStatusMapper
import zw.co.blu.exposed.sql.dao.model.permissions.PermissionModel
import zw.co.blu.exposed.sql.dao.model.roles.RoleModel
import zw.co.blu.exposed.sql.dao.tables.abilities.AbilitiesTable
import zw.co.blu.exposed.sql.dao.tables.permissions.PermissionsTable
import zw.co.blu.exposed.sql.dao.tables.permissions.toPermissionModel

fun ResultRow.toRole() = RoleModel(
        id = this[RolesTable.id].toString(),
        name = this[RolesTable.name],
        roleStatus = RoleStatusMapper().fromValue(this[RolesTable.roleStatus]),
        permissions = toPermissions(this[PermissionsTable.id]),
)

fun toPermissions(id: Int): List<PermissionModel> = transaction {
    PermissionsTable.innerJoin(AbilitiesTable).innerJoin(AbilitiesTable).select { PermissionsTable.id eq id }.map {
        it.toPermissionModel()
    }
}