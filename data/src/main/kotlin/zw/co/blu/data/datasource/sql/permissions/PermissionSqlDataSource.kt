package zw.co.blu.data.datasource.sql.permissions

import zw.co.blu.data.model.permissions.PermissionEntity
import zw.co.blu.domain.requestResult.RequestResult

interface PermissionSqlDataSource {
    suspend fun getAllPermissions(): RequestResult<List<PermissionEntity>>
    suspend fun createPermission(permission: PermissionEntity): RequestResult<PermissionEntity>
    suspend fun deactivatePermission(id: String): RequestResult<PermissionEntity>
}