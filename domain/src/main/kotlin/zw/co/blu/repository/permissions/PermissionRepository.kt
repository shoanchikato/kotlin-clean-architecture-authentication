package zw.co.blu.repository.permissions

import zw.co.blu.model.Permission
import zw.co.blu.requestResult.RequestResult

interface PermissionRepository {
    suspend fun createPermission(permission: Permission): RequestResult
    suspend fun deactivatePermission(id: String): RequestResult
}