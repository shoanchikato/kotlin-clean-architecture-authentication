package zw.co.blu.exposed.sql.dao.model.permissions

import zw.co.blu.domain.model.permissions.PermissionStatus
import zw.co.blu.domain.model.privileges.Privileges

/**
 * @property name eg "BOOKS"
 * @property permissionStatus eg "ACTIVE"
 * @property privileges eg ["READ", "EDIT"]
 */
data class PermissionModel(
        val id: String,
        val name: String,
        val permissionStatus: PermissionStatus,
        val privileges: List<Privileges>,
)
