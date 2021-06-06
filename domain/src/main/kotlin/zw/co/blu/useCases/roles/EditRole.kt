package zw.co.blu.useCases.roles

import zw.co.blu.model.RoleDao
import zw.co.blu.repository.roles.RoleRepository
import zw.co.blu.requestResult.RequestResult

class EditRole(private val roleRepository: RoleRepository) {
    suspend operator fun invoke(id: String, role: RoleDao): RequestResult {
        return roleRepository.editRole(id, role)
    }
}