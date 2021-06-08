package zw.co.blu.useCases.permissions

import zw.co.blu.model.Permission
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.permissions.PermissionService

class CreatePermission(private val permissionService: PermissionService) {
    suspend operator fun invoke(permission: Permission): RequestResult<Permission> {
        return permissionService.createPermission(permission)
    }
}