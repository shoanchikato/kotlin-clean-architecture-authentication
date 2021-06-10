package zw.co.blu.mapper.users

import Mapper
import zw.co.blu.model.users.User
import zw.co.blu.model.users.UserEntity

class UserMapper (): Mapper<UserEntity, User> {
    override fun mapFromEntity(type: UserEntity): User {
        return User(
                id = type.id,
                username = type.username,
                email = type.email,
                userStatus = type.userStatus,
                roleId = type.roleId,
        )
    }

    override fun mapToEntity(type: User): UserEntity {
        return UserEntity(
                id = type.id,
                username = type.username,
                email = type.email,
                userStatus = type.userStatus,
                roleId = type.roleId,
        )
    }
}