package zw.co.blu.useCases.roles

import zw.co.blu.model.Role
import zw.co.blu.model.RoleEditDao
import zw.co.blu.service.roles.RoleService
import zw.co.blu.requestResult.RequestResult

class EditRole(private val roleService: RoleService) {
    suspend operator fun invoke(id: String, role: RoleEditDao): RequestResult<Role> {
        return roleService.editRole(id, role)
    }
}