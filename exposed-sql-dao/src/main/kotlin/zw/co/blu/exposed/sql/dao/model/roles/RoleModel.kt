package zw.co.blu.exposed.sql.dao.model.roles

import zw.co.blu.domain.model.roles.RoleStatus
import zw.co.blu.exposed.sql.dao.model.permissions.PermissionModel

/**
 * @property id eg "3"
 * @property name eg "ADMIN", "ACCOUNT MANAGER"
 * @property roleStatus eg "ACTIVE"
 * @property permissions eg
 *
 * ```json
 * [
 *  {   "name": "BOOKS",
 *      "privileges": [
 *          "READ",
 *          "EDIT"
 *      ]
 *  },
 *  {   "name": "TASKS",
 *      "privileges": [
 *          "READ"
 *      ]
 *  }
 * ]
 * ```
 */
data class RoleModel(
        val id: String,
        val name: String,
        val roleStatus: RoleStatus,
        val permissions: List<PermissionModel>,
)