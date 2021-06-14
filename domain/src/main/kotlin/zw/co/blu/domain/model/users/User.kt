package zw.co.blu.domain.model.users

import zw.co.blu.domain.model.roles.Role

/**
 * @property id eg UUID or Long, type String is more flexible
 * @property username eg "john_doe"
 * @property email eg "john_doe@company.com"
 * @property userStatus eg "ACTIVE"
 * @property role eg
 * @see [Role]
 *
 */

data class User(
        val id: String,
        val username: String,
        val email: String,
        val userStatus: UserStatus,
        val role: Role,
)