package zw.co.blu.repository.roles

import zw.co.blu.model.Role
import zw.co.blu.requestResult.RequestResult

interface RoleRepository {
    suspend fun createRole(role: Role): RequestResult
    suspend fun editRole(role: Role): RequestResult
    suspend fun deactivateRole(role: Role): RequestResult
}