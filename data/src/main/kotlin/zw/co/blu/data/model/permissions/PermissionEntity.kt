package zw.co.blu.data.model.permissions

import zw.co.blu.domain.model.abilities.Ability
import zw.co.blu.domain.model.permissions.PermissionStatus

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
