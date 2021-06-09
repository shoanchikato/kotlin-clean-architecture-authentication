package zw.co.blu.repository.roles

import zw.co.blu.model.Role
import zw.co.blu.model.RoleDao
import zw.co.blu.model.RoleEditDao
import zw.co.blu.requestResult.RequestResult

interface RoleRepository {
    suspend fun createRole(role: RoleDao): RequestResult<Role>
    suspend fun getRole(id: String): RequestResult<Role>
    suspend fun editRole(id: String, role: RoleEditDao): RequestResult<Role>
    suspend fun deactivateRole(id: String): RequestResult<Role>
}