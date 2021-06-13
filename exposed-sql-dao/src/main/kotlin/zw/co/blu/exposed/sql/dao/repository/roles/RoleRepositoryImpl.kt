package zw.co.blu.exposed.sql.dao.repository.roles

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import zw.co.blu.data.datasource.sql.roles.RoleSqlDataSource
import zw.co.blu.data.model.roles.RoleDaoEntity
import zw.co.blu.data.model.roles.RoleEditDaoEntity
import zw.co.blu.data.model.roles.RoleEntity
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.exposed.sql.dao.mapper.roles.RoleEntityMapper
import zw.co.blu.exposed.sql.dao.mapper.roles.RoleStatusMapper
//import zw.co.blu.exposed.sql.dao.table.roles.toRole

class RoleRepositoryImpl(private val databaseConnection: Database): RoleSqlDataSource {
    override suspend fun createRole(role: RoleDaoEntity): RequestResult<RoleEntity> = try {
//        transaction {
//            val roleId = RolesTable.insert {
//                it[name] = role.name
//                it[roleStatus] = RoleStatusMapper().toValue(role.roleStatus)
//            } get RolesTable.id
//
//            val roleModel = RolesTable.select { RolesTable.id eq roleId }.single().toRole()
//
//            RequestResult.Success(value = RoleEntityMapper().mapFromModel(roleModel))
//        }
    TODO()
    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }

    override suspend fun getRole(id: String): RequestResult<RoleEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun editRole(id: String, role: RoleEditDaoEntity): RequestResult<RoleEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun deactivateRole(id: String): RequestResult<RoleEntity> {
        TODO("Not yet implemented")
    }

}