package zw.co.blu.model

/**
 * @property name eg "BOOKS"
 * @property permissionStatus eg "ACTIVE"
 * @property abilities eg ["READ", "WRITE"]
 */
data class Permission(
        val name: String,
        val permissionStatus: PermissionStatus,
        val abilities: List<Ability>,
)
