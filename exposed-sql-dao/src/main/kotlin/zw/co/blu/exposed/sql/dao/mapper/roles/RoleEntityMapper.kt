package zw.co.blu.exposed.sql.dao.mapper.roles

import zw.co.blu.data.model.roles.RoleEntity
import zw.co.blu.exposed.sql.dao.mapper.Mapper
import zw.co.blu.exposed.sql.dao.mapper.permissions.PermissionEntityMapper
import zw.co.blu.exposed.sql.dao.model.roles.RoleModel

class RoleEntityMapper: Mapper<RoleModel, RoleEntity> {
    override fun mapFromModel(type: RoleModel): RoleEntity {
        return RoleEntity(
                id = type.id,
                name = type.name,
                roleStatus = type.roleStatus,
                permissions = type.permissions.map { PermissionEntityMapper().mapFromModel(it) },
        )
    }

    override fun mapToModel(type: RoleEntity): RoleModel {
        return RoleModel(
                id = type.id,
                name = type.name,
                roleStatus = type.roleStatus,
                permissions = type.permissions.map { PermissionEntityMapper().mapToModel(it) }
        )
    }
}