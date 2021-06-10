package zw.co.blu.data.mapper.roles

import Mapper
import zw.co.blu.data.mapper.permission.PermissionMapper
import zw.co.blu.data.model.roles.RoleDaoEntity
import zw.co.blu.domain.model.roles.RoleDao

class RoleEditDaoMapper (): Mapper<RoleDaoEntity, RoleDao> {
    override fun mapFromEntity(type: RoleDaoEntity): RoleDao {
        return RoleDao(
                id = type.id,
                name = type.name,
                roleStatus = type.roleStatus,
                permissions = type.permissions.map { PermissionMapper().mapFromEntity(it) },
        )
    }

    override fun mapToEntity(type: RoleDao): RoleDaoEntity {
        return RoleDaoEntity(
                id = type.id,
                name = type.name,
                roleStatus = type.roleStatus,
                permissions = type.permissions.map { PermissionMapper().mapToEntity(it) },
        )
    }
}