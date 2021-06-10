package zw.co.blu.domain.model.permissions

import zw.co.blu.domain.model.abilities.Ability

/**
 * @property name eg "BOOKS"
 * @property permissionStatus eg "ACTIVE"
 * @property abilities eg ["READ", "EDIT"]
 */
data class Permission(
        val name: String,
        val permissionStatus: PermissionStatus,
        val abilities: List<Ability>,
)
