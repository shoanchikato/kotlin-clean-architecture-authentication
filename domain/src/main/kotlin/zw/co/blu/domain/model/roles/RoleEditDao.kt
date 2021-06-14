package zw.co.blu.domain.model.roles

/**
 * @property id eg "3"
 * @property name eg "ADMIN", "ACCOUNT MANAGER"
 * @property roleStatus eg "ACTIVE"
 * @property permissionIds eg
 *
 * ```json
 * ["1", "2"]
 * ```
 */
data class RoleEditDao(
        val id: String?,
        val name: String?,
        val roleStatus: RoleStatus?,
        val permissionIds: List<String>?,
)