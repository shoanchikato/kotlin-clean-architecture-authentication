package zw.co.blu.exposed.sql.dao.model.users

import zw.co.blu.domain.model.users.UserStatus
import zw.co.blu.exposed.sql.dao.model.roles.RoleModel

/**
 * @property id eg UUID or Long, type String is more flexible
 * @property username eg "john_doe"
 * @property email eg "john_doe@company.com"
 * @property userStatus eg "ACTIVE"
 * @property role eg
 * @see [RoleModel]
 *
 */

data class UserModel(
        val id: String,
        val username: String,
        val email: String,
        val userStatus: UserStatus,
        val role: RoleModel,
)