package zw.co.blu.data.mapper.users

import zw.co.blu.data.mapper.Mapper
import zw.co.blu.data.model.users.UserDaoEntity
import zw.co.blu.domain.model.users.UserDao

class UserDaoMapper (): Mapper<UserDaoEntity, UserDao> {
    override fun mapFromEntity(type: UserDaoEntity): UserDao {
        return UserDao(
                username = type.username,
                email = type.email,
                roleId = type.roleId,
        )
    }

    override fun mapToEntity(type: UserDao): UserDaoEntity {
        return UserDaoEntity(
                username = type.username,
                email = type.email,
                roleId = type.roleId,
        )
    }
}