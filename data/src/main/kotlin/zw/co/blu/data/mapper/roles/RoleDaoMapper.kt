package zw.co.blu.data.mapper.roles

import zw.co.blu.data.mapper.Mapper
import zw.co.blu.data.model.roles.RoleDaoEntity
import zw.co.blu.domain.model.roles.RoleDao

class RoleDaoMapper (): Mapper<RoleDaoEntity, RoleDao> {
    override fun mapFromEntity(type: RoleDaoEntity): RoleDao {
        return RoleDao(
                name = type.name,
                permissionIds = type.permissionIds,
        )
    }

    override fun mapToEntity(type: RoleDao): RoleDaoEntity {
        return RoleDaoEntity(
                name = type.name,
                permissionIds = type.permissionIds,
        )
    }
}