package zw.co.blu.exposed.sql.dao.model.roles


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
data class RoleDaoModel(
        val name: String,
        val permissionIds: List<String>,
)