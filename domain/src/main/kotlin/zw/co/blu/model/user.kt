package zw.co.blu.model

/**
 * @property username eg. "john_doe"
 * @property hash eg. BCRYPT HASH CODE
 * @property email eg. "john_doe@company.com"
 * @property role eg.
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
 * }
 */
data class User(val username: String, val hash: String, val email: String, val role: Role)