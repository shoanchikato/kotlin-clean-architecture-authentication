package zw.co.blu.useCases.permissions

import zw.co.blu.repository.permissions.PermissionRepository
import zw.co.blu.requestResult.RequestResult

class DeactivatePermission(private val permissionRepository: PermissionRepository) {
    suspend operator fun invoke(id: String): RequestResult {
        return permissionRepository.deactivatePermission(id)
    }
}