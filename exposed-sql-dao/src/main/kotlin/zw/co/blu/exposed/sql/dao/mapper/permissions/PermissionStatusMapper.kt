package zw.co.blu.exposed.sql.dao.mapper.permissions

import zw.co.blu.domain.model.permissions.PermissionStatus

class PermissionStatusMapper {
    fun fromValue(value: Int): PermissionStatus {
        return when (value) {
            1 -> PermissionStatus.ACTIVE
            else -> PermissionStatus.INACTIVE
        }
    }

    fun toValue(permissionStatus: PermissionStatus): Int {
        return when (permissionStatus) {
            is PermissionStatus.ACTIVE -> 1
            is PermissionStatus.INACTIVE -> 2
        }
    }
}