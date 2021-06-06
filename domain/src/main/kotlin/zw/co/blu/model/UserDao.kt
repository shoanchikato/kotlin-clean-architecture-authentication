package zw.co.blu.model

/**
 * @property id eg UUID or Long, type String is more flexible
 * @property username eg "john_doe"
 * @property hash eg BCRYPT HASH CODE
 * @property email eg "john_doe@company.com"
 * @property userStatus eg "ACTIVE"
 * @property role eg
 *
 * {
 *  "name": "ADMIN",
 *  "permissions": [
 *      {
 *          "name": "BOOKS",
 *          "abilities": [
 *              "READ",
 *              "WRITE"
 *          ]
 *      }
 *  ]
 * }
 */

data class UserDao(
        val id: String?,
        val username: String?,
        val hash: String?,
        val email: String?,
        val userStatus: UserStatus?,
        val role: Role?,
)