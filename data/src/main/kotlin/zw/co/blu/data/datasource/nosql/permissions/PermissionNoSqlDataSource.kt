package zw.co.blu.data.datasource.nosql.permissions

import zw.co.blu.data.model.permissions.PermissionEntity
import zw.co.blu.domain.requestResult.RequestResult

interface PermissionNoSqlDataSource {
    suspend fun createPermission(permission: PermissionEntity): RequestResult<PermissionEntity>
    suspend fun deactivatePermission(id: String): RequestResult<PermissionEntity>
}