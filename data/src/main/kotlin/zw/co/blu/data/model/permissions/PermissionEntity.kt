package zw.co.blu.data.model.permissions

import zw.co.blu.domain.model.permissions.PermissionStatus
import zw.co.blu.domain.model.privileges.Privileges

/**
 * @property id eg "1"
 * @property name eg "BOOKS"
 * @property permissionStatus eg "ACTIVE"
 * @property privileges eg ["READ", "EDIT"]
 */
data class PermissionEntity(
        val id: String,
        val name: String,
        val permissionStatus: PermissionStatus,
        val privileges: List<Privileges>,
)
