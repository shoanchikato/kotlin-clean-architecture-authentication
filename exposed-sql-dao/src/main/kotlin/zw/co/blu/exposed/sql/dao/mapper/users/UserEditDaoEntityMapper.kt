package zw.co.blu.exposed.sql.dao.mapper.users

import zw.co.blu.data.model.users.UserEditDaoEntity
import zw.co.blu.exposed.sql.dao.mapper.Mapper
import zw.co.blu.exposed.sql.dao.model.users.UserEditDaoModel
import zw.co.blu.exposed.sql.dao.model.users.UserModel

class UserEditDaoEntityMapper (): Mapper<UserEditDaoModel, UserEditDaoEntity> {
    override fun mapFromModel(type: UserEditDaoModel): UserEditDaoEntity {
        return UserEditDaoEntity(
                id = type.id,
                username = type.username,
                email = type.email,
                userStatus = type.userStatus,
                roleId = type.roleId,
        )
    }

    override fun mapToModel(type: UserEditDaoEntity): UserEditDaoModel {
        return UserEditDaoModel(
                id = type.id,
                username = type.username,
                email = type.email,
                userStatus = type.userStatus,
                roleId = type.roleId,
        )
    }
}