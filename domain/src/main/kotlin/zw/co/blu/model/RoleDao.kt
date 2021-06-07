package zw.co.blu.model

/**
 * @property name eg "ADMIN", "ACCOUNT MANAGER"
 * @property roleStatus eg "ACTIVE"
 * @property permissions eg
 *
 * ```json
 * [
 *  {   "name": "BOOKS",
 *      "abilities": [
 *          "READ",
 *          "EDIT"
 *      ]
 *  },
 *  {   "name": "TASKS",
 *      "abilities": [
 *          "READ"
 *      ]
 *  }
 * ]
 * ```
 */
data class RoleDao(
        val name: String?,
        val roleStatus: RoleStatus?,
        val permissions: List<Permission>?,
)