package zw.co.blu.useCases.roles

import zw.co.blu.model.roles.Role
import zw.co.blu.model.roles.RoleDao
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.roles.RoleService

class CreateRole(private val roleService: RoleService) {
    suspend operator fun invoke(role: RoleDao): RequestResult<Role> {
        return roleService.createRole(role)
    }
}