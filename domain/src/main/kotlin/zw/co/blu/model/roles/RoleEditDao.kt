package zw.co.blu.model.roles

import zw.co.blu.model.permissions.Permission

/**
 * @property id eg "3"
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
data class RoleEditDao(
        val id: String?,
        val name: String?,
        val roleStatus: RoleStatus?,
        val permissions: List<Permission>?,
)