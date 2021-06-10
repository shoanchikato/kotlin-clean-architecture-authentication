package zw.co.blu.datasource.sql.permissions

import zw.co.blu.model.permissions.PermissionEntity
import zw.co.blu.requestResult.RequestResult

interface PermissionSqlDataSource {
    suspend fun createPermission(permission: PermissionEntity): RequestResult<PermissionEntity>
    suspend fun deactivatePermission(id: String): RequestResult<PermissionEntity>
}