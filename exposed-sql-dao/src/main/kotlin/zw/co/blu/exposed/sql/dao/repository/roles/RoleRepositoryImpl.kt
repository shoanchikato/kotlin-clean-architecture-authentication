package zw.co.blu.exposed.sql.dao.repository.roles

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.transactions.transaction
import zw.co.blu.data.datasource.sql.roles.RoleSqlDataSource
import zw.co.blu.data.model.roles.RoleDaoEntity
import zw.co.blu.data.model.roles.RoleEditDaoEntity
import zw.co.blu.data.model.roles.RoleEntity
import zw.co.blu.domain.model.roles.RoleStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.exposed.sql.dao.mapper.roles.RoleStatusMapper
import zw.co.blu.exposed.sql.dao.table.permissions.PermissionsEntity
import zw.co.blu.exposed.sql.dao.table.roles.RolesEntity


class RoleRepositoryImpl(private val databaseConnection: Database) : RoleSqlDataSource {

    override suspend fun createRole(role: RoleDaoEntity): RequestResult<RoleEntity> = try {
        val roleDao = transaction {
            RolesEntity.new {
                name = role.name
                roleStatus = RoleStatusMapper().toValue(RoleStatus.ACTIVE)
            }
        }

        val permissions = role.permissionIds.map { permissionId ->
            transaction {
                PermissionsEntity.findById(permissionId.toInt())
                        ?: throw Exception("Permission with $permissionId ID not found")
            }
        }

        val result = transaction {
            roleDao.permissions = SizedCollection(permissions)
            roleDao.toDataEntity()
        }

        RequestResult.Success(result)

    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }

    override suspend fun getRoleById(id: String): RequestResult<RoleEntity> = try {
        transaction {
            val role = RolesEntity.findById(id.toInt()) ?: throw Exception("Role with $id ID not found")

            RequestResult.Success(role.toDataEntity())
        }
    } catch (e: Exception) {
        RequestResult.Error(e)
    }

    override suspend fun getAllRoles(): RequestResult<List<RoleEntity>> = try {
        transaction {
            val roles = RolesEntity.all()

            val rolesEntity: List<RoleEntity> = roles.map { it.toDataEntity() }

            RequestResult.Success(rolesEntity)
        }
    } catch (e: Exception) {
        RequestResult.Error(e)
    }

    override suspend fun editRole(id: String, role: RoleEditDaoEntity): RequestResult<RoleEntity> = try {

        transaction {
            val roleDao = RolesEntity.findById(id.toInt()) ?: throw Exception("Role with $id ID not found")

            roleDao.name = role.name ?: roleDao.name
            roleDao.roleStatus = role.roleStatus?.let { RoleStatusMapper().toValue(it) } ?: roleDao.roleStatus

            val permissions = role.permissionIds?.let {
                transaction {
                    role.permissionIds?.map { permissionId ->
                        PermissionsEntity.findById(permissionId.toInt())
                                ?: throw Exception("Permission with $id ID not found")
                    }
                }
            }

            if (permissions != null) transaction { roleDao.permissions = SizedCollection(permissions) }

            RequestResult.Success(roleDao.toDataEntity())
        }
    } catch (e: Exception) {
        RequestResult.Error(e)
    }

    override suspend fun deactivateRole(id: String): RequestResult<RoleEntity> = try {
        transaction {
            val roleDao = RolesEntity.findById(id.toInt()) ?: throw Exception("Role with $id ID not found")

            roleDao.roleStatus = RoleStatusMapper().toValue(RoleStatus.INACTIVE)

            RequestResult.Success(roleDao.toDataEntity())
        }
    } catch (e: Exception) {
        RequestResult.Error(e)
    }
}