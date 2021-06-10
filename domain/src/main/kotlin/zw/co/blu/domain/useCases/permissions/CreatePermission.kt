package zw.co.blu.domain.useCases.permissions

import zw.co.blu.domain.model.permissions.Permission
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.permissions.PermissionService

class CreatePermission(private val permissionService: PermissionService) {
    suspend operator fun invoke(permission: Permission): RequestResult<Permission> {
        return permissionService.createPermission(permission)
    }
}