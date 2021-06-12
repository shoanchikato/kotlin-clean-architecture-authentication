package zw.co.blu.domain.repository.permissions

import zw.co.blu.domain.model.permissions.Permission
import zw.co.blu.domain.requestResult.RequestResult

interface PermissionRepository {
    suspend fun getAllPermissions(): RequestResult<List<Permission>>
    suspend fun createPermission(permission: Permission): RequestResult<Permission>
    suspend fun deactivatePermission(id: String): RequestResult<Permission>
}