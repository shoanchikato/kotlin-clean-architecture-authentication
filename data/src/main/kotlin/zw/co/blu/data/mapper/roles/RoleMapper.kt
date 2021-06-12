package zw.co.blu.data.mapper.roles

import zw.co.blu.data.mapper.Mapper
import zw.co.blu.data.mapper.permission.PermissionMapper
import zw.co.blu.data.model.roles.RoleEntity
import zw.co.blu.domain.model.roles.Role

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