package zw.co.blu.useCases.roles

import zw.co.blu.model.Role
import zw.co.blu.service.roles.RoleService
import zw.co.blu.requestResult.RequestResult

class DeactivateRole(private val roleService: RoleService) {
    suspend operator fun invoke(id: String): RequestResult<Role> {
        return roleService.deactivateRole(id)
    }
}