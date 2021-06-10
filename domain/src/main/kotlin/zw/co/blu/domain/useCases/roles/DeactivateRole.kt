package zw.co.blu.domain.useCases.roles

import zw.co.blu.domain.model.roles.Role
import zw.co.blu.domain.service.roles.RoleService
import zw.co.blu.domain.requestResult.RequestResult

class DeactivateRole(private val roleService: RoleService) {
    suspend operator fun invoke(id: String): RequestResult<Role> {
        return roleService.deactivateRole(id)
    }
}