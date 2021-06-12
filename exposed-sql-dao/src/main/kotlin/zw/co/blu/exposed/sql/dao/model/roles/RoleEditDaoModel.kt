package zw.co.blu.exposed.sql.dao.model.roles

import zw.co.blu.data.model.permissions.PermissionEntity
import zw.co.blu.domain.model.roles.RoleStatus

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
data class RoleEditDaoModel(
        val id: String?,
        val name: String?,
        val roleStatus: RoleStatus?,
        val permissions: List<PermissionEntity>?,
)