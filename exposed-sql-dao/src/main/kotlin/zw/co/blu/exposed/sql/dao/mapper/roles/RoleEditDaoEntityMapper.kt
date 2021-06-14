package zw.co.blu.exposed.sql.dao.mapper.roles

import zw.co.blu.data.model.roles.RoleEditDaoEntity
import zw.co.blu.exposed.sql.dao.mapper.Mapper
import zw.co.blu.exposed.sql.dao.model.roles.RoleEditDaoModel

class RoleEditDaoEntityMapper (): Mapper<RoleEditDaoModel, RoleEditDaoEntity> {
    override fun mapFromModel(type: RoleEditDaoModel): RoleEditDaoEntity {
        return RoleEditDaoEntity(
                id = type.id,
                name = type.name,
                roleStatus = type.roleStatus,
                permissionIds = type.permissionIds,
        )
    }

    override fun mapToModel(type: RoleEditDaoEntity): RoleEditDaoModel {
        return RoleEditDaoModel(
                id = type.id,
                name = type.name,
                roleStatus = type.roleStatus,
                permissionIds = type.permissionIds,
        )
    }
}