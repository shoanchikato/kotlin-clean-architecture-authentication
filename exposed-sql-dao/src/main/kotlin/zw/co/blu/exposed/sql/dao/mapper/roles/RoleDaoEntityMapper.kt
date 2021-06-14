package zw.co.blu.exposed.sql.dao.mapper.roles

import zw.co.blu.data.model.roles.RoleDaoEntity
import zw.co.blu.exposed.sql.dao.mapper.Mapper
import zw.co.blu.exposed.sql.dao.model.roles.RoleDaoModel

class RoleDaoEntityMapper (): Mapper<RoleDaoEntity, RoleDaoModel> {
    override fun mapFromModel(type: RoleDaoEntity): RoleDaoModel {
        return RoleDaoModel(
                name = type.name,
                permissionIds = type.permissionIds,
        )
    }

    override fun mapToModel(type: RoleDaoModel): RoleDaoEntity {
        return RoleDaoEntity(
                name = type.name,
                permissionIds = type.permissionIds,
        )
    }
}