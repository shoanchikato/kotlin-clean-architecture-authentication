package zw.co.blu.mapper.roles

import Mapper
import zw.co.blu.mapper.permission.PermissionMapper
import zw.co.blu.model.roles.Role
import zw.co.blu.model.roles.RoleEntity

class RoleMapper (): Mapper<RoleEntity, Role> {
    override fun mapFromEntity(type: RoleEntity): Role {
        return Role(
                 id = type.id,
                name = type.name,
                roleStatus = type.roleStatus,
                permissions = type.permissions.map { PermissionMapper().mapFromEntity(it) },
        )
    }

    override fun mapToEntity(type: Role): RoleEntity {
        return RoleEntity(
                 id = type.id,
                name = type.name,
                roleStatus = type.roleStatus,
                permissions = type.permissions.map { PermissionMapper().mapToEntity(it) }
        )
    }
}