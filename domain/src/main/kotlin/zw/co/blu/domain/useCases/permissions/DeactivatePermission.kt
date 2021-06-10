package zw.co.blu.domain.useCases.permissions

import zw.co.blu.domain.model.permissions.Permission
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.permissions.PermissionService

class DeactivatePermission(private val permissionService: PermissionService) {
    suspend operator fun invoke(id: String): RequestResult<Permission> {
        return permissionService.deactivatePermission(id)
    }
}