package zw.co.blu.domain.model.permissions

import zw.co.blu.domain.model.privileges.Privileges

/**
 * @property name eg "BOOKS"
 * @property permissionStatus eg "ACTIVE"
 * @property privileges eg ["READ", "EDIT"]
 */
data class Permission(
        val id: String,
        val name: String,
        val permissionStatus: PermissionStatus,
        val privileges: List<Privileges>,
)
