package zw.co.blu.useCases.permissions

import zw.co.blu.model.permissions.Permission
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.permissions.PermissionService

class DeactivatePermission(private val permissionService: PermissionService) {
    suspend operator fun invoke(id: String): RequestResult<Permission> {
        return permissionService.deactivatePermission(id)
    }
}