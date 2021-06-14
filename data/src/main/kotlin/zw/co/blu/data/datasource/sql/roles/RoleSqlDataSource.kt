package zw.co.blu.data.datasource.sql.roles

import zw.co.blu.data.model.roles.RoleDaoEntity
import zw.co.blu.data.model.roles.RoleEditDaoEntity
import zw.co.blu.data.model.roles.RoleEntity
import zw.co.blu.domain.requestResult.RequestResult

interface RoleSqlDataSource {
    suspend fun createRole(role: RoleDaoEntity): RequestResult<RoleEntity>
    suspend fun getRoleById(id: String): RequestResult<RoleEntity>
    suspend fun getAllRoles(): RequestResult<List<RoleEntity>>
    suspend fun editRole(id: String, role: RoleEditDaoEntity): RequestResult<RoleEntity>
    suspend fun deactivateRole(id: String): RequestResult<RoleEntity>
}