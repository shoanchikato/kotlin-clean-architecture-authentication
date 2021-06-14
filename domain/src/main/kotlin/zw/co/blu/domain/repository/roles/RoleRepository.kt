package zw.co.blu.domain.repository.roles

import zw.co.blu.domain.model.roles.Role
import zw.co.blu.domain.model.roles.RoleDao
import zw.co.blu.domain.model.roles.RoleEditDao
import zw.co.blu.domain.requestResult.RequestResult

interface RoleRepository {
    suspend fun createRole(role: RoleDao): RequestResult<Role>
    suspend fun getRoleById(id: String): RequestResult<Role>
    suspend fun getAllRoles(): RequestResult<List<Role>>
    suspend fun editRole(id: String, role: RoleEditDao): RequestResult<Role>
    suspend fun deactivateRole(id: String): RequestResult<Role>
}