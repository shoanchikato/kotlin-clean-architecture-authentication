package zw.co.blu.exposed.sql.dao.mapper.users

import zw.co.blu.data.model.users.UserEntity
import zw.co.blu.exposed.sql.dao.mapper.Mapper
import zw.co.blu.exposed.sql.dao.model.users.UserModel

class UserEntityMapper (): Mapper<UserModel, UserEntity> {
    override fun mapFromModel(type: UserModel): UserEntity {
        return UserEntity(
                id = type.id,
                username = type.username,
                email = type.email,
                userStatus = type.userStatus,
                roleId = type.roleId,
        )
    }

    override fun mapToModel(type: UserEntity): UserModel {
        return UserModel(
                id = type.id,
                username = type.username,
                email = type.email,
                userStatus = type.userStatus,
                roleId = type.roleId,
        )
    }
}