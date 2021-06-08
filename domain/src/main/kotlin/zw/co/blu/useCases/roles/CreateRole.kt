package zw.co.blu.useCases.roles

import zw.co.blu.model.Role
import zw.co.blu.service.roles.RoleService
import zw.co.blu.requestResult.RequestResult

class CreateRole(private val roleService: RoleService) {
    suspend operator fun invoke(role: Role): RequestResult<Role> {
        return roleService.createRole(role)
    }
}