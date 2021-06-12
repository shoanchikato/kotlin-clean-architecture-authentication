package zw.co.blu.exposed.sql.dao.mapper.roles

import zw.co.blu.data.model.roles.RoleDaoEntity
import zw.co.blu.exposed.sql.dao.mapper.Mapper
import zw.co.blu.exposed.sql.dao.mapper.permissions.PermissionEntityMapper
import zw.co.blu.exposed.sql.dao.model.roles.RoleDaoModel

class RoleDaoEntityMapper (): Mapper<RoleDaoEntity, RoleDaoModel> {
    override fun mapFromModel(type: RoleDaoEntity): RoleDaoModel {
        return RoleDaoModel(
                id = type.id,
                name = type.name,
                roleStatus = type.roleStatus,
                permissions = type.permissions.map { PermissionEntityMapper().mapToModel(it) },
        )
    }

    override fun mapToModel(type: RoleDaoModel): RoleDaoEntity {
        return RoleDaoEntity(
                id = type.id,
                name = type.name,
                roleStatus = type.roleStatus,
                permissions = type.permissions.map { PermissionEntityMapper().mapFromModel(it) },
        )
    }
}