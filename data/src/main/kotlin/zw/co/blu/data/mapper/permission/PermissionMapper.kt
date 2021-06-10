package zw.co.blu.data.mapper.permission

import Mapper
import zw.co.blu.data.model.permissions.PermissionEntity
import zw.co.blu.domain.model.permissions.Permission

class PermissionMapper (): Mapper<PermissionEntity, Permission> {
    override fun mapFromEntity(type: PermissionEntity): Permission {
        return Permission(
                name = type.name,
                permissionStatus = type.permissionStatus,
                abilities = type.abilities,
        )
    }

    override fun mapToEntity(type: Permission): PermissionEntity {
        return PermissionEntity(
                name = type.name,
                permissionStatus = type.permissionStatus,
                abilities = type.abilities,
        )
    }
}