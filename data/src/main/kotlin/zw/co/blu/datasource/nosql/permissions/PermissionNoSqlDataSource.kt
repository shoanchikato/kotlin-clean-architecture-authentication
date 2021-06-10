package zw.co.blu.datasource.nosql.permissions

import zw.co.blu.model.permissions.PermissionEntity
import zw.co.blu.requestResult.RequestResult

interface PermissionNoSqlDataSource {
    suspend fun createPermission(permission: PermissionEntity): RequestResult<PermissionEntity>
    suspend fun deactivatePermission(id: String): RequestResult<PermissionEntity>
}