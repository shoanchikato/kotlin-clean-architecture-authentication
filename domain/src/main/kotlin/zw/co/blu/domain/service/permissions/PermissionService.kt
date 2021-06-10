package zw.co.blu.domain.service.permissions

import zw.co.blu.domain.model.permissions.Permission
import zw.co.blu.domain.requestResult.RequestResult

interface PermissionService {
    suspend fun createPermission(permission: Permission): RequestResult<Permission>
    suspend fun deactivatePermission(id: String): RequestResult<Permission>
}