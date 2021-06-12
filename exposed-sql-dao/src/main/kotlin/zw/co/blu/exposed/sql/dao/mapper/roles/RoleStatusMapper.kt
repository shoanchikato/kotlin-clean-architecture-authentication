package zw.co.blu.exposed.sql.dao.mapper.roles

import zw.co.blu.domain.model.roles.RoleStatus

class RoleStatusMapper {
    fun fromValue(value: Int): RoleStatus {
        return when (value) {
            1 -> RoleStatus.ACTIVE
            else -> RoleStatus.INACTIVE
        }
    }

    fun toValue(permissionStatus: RoleStatus): Int {
        return when (permissionStatus) {
            is RoleStatus.ACTIVE -> 1
            is RoleStatus.INACTIVE -> 2
        }
    }
}
