package zw.co.blu.exposed.sql.dao.mapper.users

import zw.co.blu.domain.model.users.UserStatus

class UserStatusMapper {
    fun fromValue(value: Int): UserStatus {
        return when (value) {
            1 -> UserStatus.ACTIVE
            2 -> UserStatus.INACTIVE
            3 -> UserStatus.PENDING
            4 -> UserStatus.SUSPENDED
            5 -> UserStatus.BANNED
            else -> UserStatus.INACTIVE
        }
    }

    fun toValue(userStatus: UserStatus): Int {
        return when (userStatus) {
            is UserStatus.ACTIVE -> 1
            is UserStatus.INACTIVE -> 2
            is UserStatus.PENDING -> 3
            is UserStatus.SUSPENDED -> 4
            is UserStatus.BANNED -> 5
            else -> 2
        }
    }
}