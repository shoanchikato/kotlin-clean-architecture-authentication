package zw.co.blu.data.model.users

import zw.co.blu.domain.model.users.UserStatus

/**
 * @property username eg "john_doe"
 * @property email eg "john_doe@company.com"
 * @property roleId eg "1"
 *
 */

data class UserDaoEntity(
        val username: String,
        val email: String,
        val roleId: String,
)