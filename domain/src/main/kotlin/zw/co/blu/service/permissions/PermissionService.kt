package zw.co.blu.service.permissions

import zw.co.blu.model.Permission
import zw.co.blu.requestResult.RequestResult

interface PermissionService {
    suspend fun createPermission(permission: Permission): RequestResult<Permission>
    suspend fun deactivatePermission(id: String): RequestResult<Permission>
}