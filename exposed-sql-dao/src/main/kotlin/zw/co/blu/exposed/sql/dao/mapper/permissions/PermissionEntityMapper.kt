package zw.co.blu.exposed.sql.dao.mapper.permissions

import zw.co.blu.data.model.permissions.PermissionEntity
import zw.co.blu.exposed.sql.dao.mapper.Mapper
import zw.co.blu.exposed.sql.dao.model.permissions.PermissionModel

class PermissionEntityMapper (): Mapper<PermissionModel, PermissionEntity> {
    override fun mapFromModel(type: PermissionModel): PermissionEntity {
        return PermissionEntity(
                name = type.name,
                permissionStatus = type.permissionStatus,
                abilities = type.abilities,
        )
    }

    override fun mapToModel(type: PermissionEntity): PermissionModel {
        return PermissionModel(
                name = type.name,
                permissionStatus = type.permissionStatus,
                abilities = type.abilities,
        )
    }
}