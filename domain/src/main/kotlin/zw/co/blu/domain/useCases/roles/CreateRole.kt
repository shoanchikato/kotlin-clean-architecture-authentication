package zw.co.blu.domain.useCases.roles

import zw.co.blu.domain.model.roles.Role
import zw.co.blu.domain.model.roles.RoleDao
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.roles.RoleService

class CreateRole(private val roleService: RoleService) {
    suspend operator fun invoke(role: RoleDao): RequestResult<Role> {
        return roleService.createRole(role)
    }
}