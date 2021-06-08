package zw.co.blu.repository.roles

import zw.co.blu.model.Role
import zw.co.blu.model.RoleDao
import zw.co.blu.requestResult.RequestResult

interface RoleRepository {
    suspend fun createRole(role: Role): RequestResult<Role>
    suspend fun editRole(id: String, role: RoleDao): RequestResult<Role>
    suspend fun deactivateRole(id: String): RequestResult<Role>
}