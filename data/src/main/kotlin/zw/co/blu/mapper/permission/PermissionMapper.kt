package zw.co.blu.mapper.permission

import Mapper
import zw.co.blu.model.permissions.Permission
import zw.co.blu.model.permissions.PermissionEntity

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