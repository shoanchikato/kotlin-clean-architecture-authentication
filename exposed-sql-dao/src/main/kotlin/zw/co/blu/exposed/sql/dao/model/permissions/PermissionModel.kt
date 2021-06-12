package zw.co.blu.exposed.sql.dao.model.permissions

import zw.co.blu.domain.model.abilities.Ability
import zw.co.blu.domain.model.permissions.PermissionStatus

/**
 * @property name eg "BOOKS"
 * @property permissionStatus eg "ACTIVE"
 * @property abilities eg ["READ", "EDIT"]
 */
data class PermissionModel(
        val name: String,
        val permissionStatus: PermissionStatus,
        val abilities: List<Ability>,
)
