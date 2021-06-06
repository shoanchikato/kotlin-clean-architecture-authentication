package zw.co.blu.useCases.permissions

import zw.co.blu.model.Permission
import zw.co.blu.repository.permissions.PermissionRepository
import zw.co.blu.requestResult.RequestResult

class CreatePermission(private val permissionRepository: PermissionRepository) {
    suspend operator fun invoke(permission: Permission): RequestResult {
        return permissionRepository.createPermission(permission)
    }
}