package zw.co.blu.data.mapper.roles

import zw.co.blu.data.mapper.Mapper
import zw.co.blu.data.model.roles.RoleEditDaoEntity
import zw.co.blu.domain.model.roles.RoleEditDao

class RoleEditDaoMapper (): Mapper<RoleEditDaoEntity, RoleEditDao> {
    override fun mapFromEntity(type: RoleEditDaoEntity): RoleEditDao {
        return RoleEditDao(
                id = type.id,
                name = type.name,
                roleStatus = type.roleStatus,
                permissionIds = type.permissionIds,
        )
    }

    override fun mapToEntity(type: RoleEditDao): RoleEditDaoEntity {
        return RoleEditDaoEntity(
                id = type.id,
                name = type.name,
                roleStatus = type.roleStatus,
                permissionIds = type.permissionIds,
        )
    }
}