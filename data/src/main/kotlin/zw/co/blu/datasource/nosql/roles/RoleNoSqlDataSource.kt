package zw.co.blu.datasource.nosql.roles

import zw.co.blu.model.roles.RoleDaoEntity
import zw.co.blu.model.roles.RoleEditDaoEntity
import zw.co.blu.model.roles.RoleEntity
import zw.co.blu.requestResult.RequestResult

interface RoleNoSqlDataSource {
    suspend fun createRole(role: RoleDaoEntity): RequestResult<RoleEntity>
    suspend fun getRole(id: String): RequestResult<RoleEntity>
    suspend fun editRole(id: String, role: RoleEditDaoEntity): RequestResult<RoleEntity>
    suspend fun deactivateRole(id: String): RequestResult<RoleEntity>
}