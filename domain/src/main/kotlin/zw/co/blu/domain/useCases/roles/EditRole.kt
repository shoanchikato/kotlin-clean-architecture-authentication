package zw.co.blu.domain.useCases.roles

import zw.co.blu.domain.model.roles.Role
import zw.co.blu.domain.model.roles.RoleEditDao
import zw.co.blu.domain.service.roles.RoleService
import zw.co.blu.domain.requestResult.RequestResult

class EditRole(private val roleService: RoleService) {
    suspend operator fun invoke(id: String, role: RoleEditDao): RequestResult<Role> {
        return roleService.editRole(id, role)
    }
}