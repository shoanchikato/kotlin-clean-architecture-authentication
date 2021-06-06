package zw.co.blu.repository.roles

import zw.co.blu.model.Role
import zw.co.blu.model.RoleDao
import zw.co.blu.requestResult.RequestResult

interface RoleRepository {
    suspend fun createRole(role: Role): RequestResult
    suspend fun editRole(id: String, role: RoleDao): RequestResult
    suspend fun deactivateRole(id: String): RequestResult
}