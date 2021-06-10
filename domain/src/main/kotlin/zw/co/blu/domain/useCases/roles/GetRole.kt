package zw.co.blu.domain.useCases.roles

import zw.co.blu.domain.model.roles.Role
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.roles.RoleService

class GetRole(private val roleService: RoleService) {
    suspend operator fun invoke(id: String): RequestResult<Role> {
        return roleService.getRole(id)
    }
}