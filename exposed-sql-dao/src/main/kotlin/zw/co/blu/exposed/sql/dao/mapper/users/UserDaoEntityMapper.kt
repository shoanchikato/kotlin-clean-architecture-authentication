package zw.co.blu.exposed.sql.dao.mapper.users

import zw.co.blu.data.model.users.UserDaoEntity
import zw.co.blu.exposed.sql.dao.mapper.Mapper
import zw.co.blu.exposed.sql.dao.model.users.UserDaoModel

class UserDaoEntityMapper (): Mapper<UserDaoModel, UserDaoEntity> {
    override fun mapFromModel(type: UserDaoModel): UserDaoEntity {
        return UserDaoEntity(
                id = type.id,
                username = type.username,
                email = type.email,
                userStatus = type.userStatus,
                roleId = type.roleId,
        )
    }

    override fun mapToModel(type: UserDaoEntity): UserDaoModel {
        return UserDaoModel(
                id = type.id,
                username = type.username,
                email = type.email,
                userStatus = type.userStatus,
                roleId = type.roleId,
        )
    }
}