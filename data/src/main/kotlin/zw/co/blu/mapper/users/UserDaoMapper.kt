package zw.co.blu.mapper.users

import Mapper
import zw.co.blu.model.users.UserDao
import zw.co.blu.model.users.UserDaoEntity

class UserDaoMapper (): Mapper<UserDaoEntity, UserDao> {
    override fun mapFromEntity(type: UserDaoEntity): UserDao {
        return UserDao(
                id = type.id,
                username = type.username,
                email = type.email,
                userStatus = type.userStatus,
                roleId = type.roleId,
        )
    }

    override fun mapToEntity(type: UserDao): UserDaoEntity {
        return UserDaoEntity(
                id = type.id,
                username = type.username,
                email = type.email,
                userStatus = type.userStatus,
                roleId = type.roleId,
        )
    }
}