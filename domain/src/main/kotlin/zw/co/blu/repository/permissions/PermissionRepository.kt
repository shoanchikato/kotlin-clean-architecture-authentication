package zw.co.blu.repository.permissions

import zw.co.blu.model.permissions.Permission
import zw.co.blu.requestResult.RequestResult

interface PermissionRepository {
    suspend fun createPermission(permission: Permission): RequestResult<Permission>
    suspend fun deactivatePermission(id: String): RequestResult<Permission>
}