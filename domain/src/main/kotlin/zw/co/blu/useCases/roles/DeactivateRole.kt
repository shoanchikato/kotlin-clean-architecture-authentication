package zw.co.blu.useCases.roles

import zw.co.blu.repository.roles.RoleRepository
import zw.co.blu.requestResult.RequestResult

class DeactivateRole(private val roleRepository: RoleRepository) {
    suspend operator fun invoke(id: String): RequestResult {
        return roleRepository.deactivateRole(id)
    }
}