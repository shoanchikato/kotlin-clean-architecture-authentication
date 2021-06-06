package zw.co.blu.useCases.roles

import zw.co.blu.model.Role
import zw.co.blu.repository.roles.RoleRepository
import zw.co.blu.requestResult.RequestResult

class CreateRole(private val roleRepository: RoleRepository) {
    suspend operator fun invoke(role: Role): RequestResult {
        return roleRepository.createRole(role)
    }
}