package zw.co.blu.data.model.users

import zw.co.blu.domain.model.users.UserStatus

/**
 * @property id eg UUID or Long, type String is more flexible
 * @property username eg "john_doe"
 * @property email eg "john_doe@company.com"
 * @property userStatus eg "ACTIVE"
 * @property roleId eg "1"
 *
 */

data class UserDaoEntity(
        val id: String?,
        val username: String,
        val email: String,
        val userStatus: UserStatus,
        val roleId: String,
)