package zw.co.blu.data.mapper.users

import zw.co.blu.data.mapper.Mapper
import zw.co.blu.data.model.users.UserEntity
import zw.co.blu.domain.model.users.User

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