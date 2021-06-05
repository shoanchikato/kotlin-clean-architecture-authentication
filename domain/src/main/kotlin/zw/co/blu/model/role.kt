package zw.co.blu.model

/**
 * @property name eg. "ADMIN", "ACCOUNT MANAGER"
 * @property permissions eg.
 *
 * [
 *  {   "name": "BOOKS",
 *      "abilities": [
 *          "READ",
 *          "WRITE"
 *      ]
 *  },
 *  {   "name": "TASKS",
 *      "abilities": [
 *          "READ"
 *      ]
 *  }
 * ]
 */
data class Role(val name: String, val permissions: List<Permission>)