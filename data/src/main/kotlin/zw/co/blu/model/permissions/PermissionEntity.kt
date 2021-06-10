package zw.co.blu.model.permissions

import zw.co.blu.model.abilities.Ability

/**
 * @property name eg "BOOKS"
 * @property permissionStatus eg "ACTIVE"
 * @property abilities eg ["READ", "EDIT"]
 */
data class PermissionEntity(
        val name: String,
        val permissionStatus: PermissionStatus,
        val abilities: List<Ability>,
)
