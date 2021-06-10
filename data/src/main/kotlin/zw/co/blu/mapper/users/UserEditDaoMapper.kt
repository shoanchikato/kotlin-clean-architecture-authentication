package zw.co.blu.mapper.users

import Mapper
import zw.co.blu.model.users.UserEditDao
import zw.co.blu.model.users.UserEditDaoEntity

class UserEditDaoMapper (): Mapper<UserEditDaoEntity, UserEditDao> {
    override fun mapFromEntity(type: UserEditDaoEntity): UserEditDao {
        return UserEditDao(
                id = type.id,
                username = type.username,
                email = type.email,
                userStatus = type.userStatus,
                roleId = type.roleId,
        )
    }

    override fun mapToEntity(type: UserEditDao): UserEditDaoEntity {
        return UserEditDaoEntity(
                id = type.id,
                username = type.username,
                email = type.email,
                userStatus = type.userStatus,
                roleId = type.roleId,
        )
    }
}