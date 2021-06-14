package zw.co.blu.data.mapper.permission

import zw.co.blu.data.mapper.Mapper
import zw.co.blu.data.model.permissions.PermissionEntity
import zw.co.blu.domain.model.permissions.Permission

class PermissionMapper (): Mapper<PermissionEntity, Permission> {
    override fun mapFromEntity(type: PermissionEntity): Permission {
        return Permission(
                id = type.id,
                name = type.name,
                permissionStatus = type.permissionStatus,
                privileges = type.privileges,
        )
    }

    override fun mapToEntity(type: Permission): PermissionEntity {
        return PermissionEntity(
                id = type.id,
                name = type.name,
                permissionStatus = type.permissionStatus,
                privileges = type.privileges,
        )
    }
}