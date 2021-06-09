package zw.co.blu.useCases.roles

import zw.co.blu.model.Role
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.roles.RoleService

class GetRole(private val roleService: RoleService) {
    suspend operator fun invoke(id: String): RequestResult<Role> {
        return roleService.getRole(id)
    }
}