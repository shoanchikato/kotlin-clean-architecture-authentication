package zw.co.blu.domain.model.roles

/**
 * @property name eg "ADMIN", "ACCOUNT MANAGER"
 * @property permissionIds eg
 *
 * ```json
 * ["1", "2"]
 * ```
 */
data class RoleDao(
        val name: String,
        val permissionIds: List<String>,
)