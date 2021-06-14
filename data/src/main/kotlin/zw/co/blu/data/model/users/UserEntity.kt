package zw.co.blu.data.model.users

import zw.co.blu.data.model.roles.RoleEntity
import zw.co.blu.domain.model.users.UserStatus

/**
 * @property id eg UUID or Long, type String is more flexible
 * @property username eg "john_doe"
 * @property email eg "john_doe@company.com"
 * @property userStatus eg "ACTIVE"
 * @property role eg
 * @see [RoleEntity]
 *
 */

data class UserEntity(
        val id: String,
        val username: String,
        val email: String,
        val userStatus: UserStatus,
        val role: RoleEntity,
)