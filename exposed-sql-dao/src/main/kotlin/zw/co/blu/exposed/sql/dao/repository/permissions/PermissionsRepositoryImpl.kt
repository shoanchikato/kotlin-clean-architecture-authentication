package zw.co.blu.exposed.sql.dao.repository.permissions

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.transactions.transaction
import zw.co.blu.data.datasource.sql.permissions.PermissionSqlDataSource
import zw.co.blu.data.model.permissions.PermissionEntity
import zw.co.blu.domain.model.permissions.PermissionStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.exposed.sql.dao.mapper.permissions.PermissionStatusMapper
import zw.co.blu.exposed.sql.dao.mapper.privileges.PrivilegesMapper
import zw.co.blu.exposed.sql.dao.table.permissions.PermissionsEntity
import zw.co.blu.exposed.sql.dao.table.privileges.PrivilegesEntity

class PermissionsRepositoryImpl(private val databaseConnection: Database) : PermissionSqlDataSource {

    override suspend fun getAllPermissions(): RequestResult<List<PermissionEntity>> = try {
        transaction {
            val permissionsDao = PermissionsEntity.all()

            val permissions = permissionsDao.map { it.toDataEntity() }

            RequestResult.Success(value = permissions)
        }
    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }

    override suspend fun createPermission(permission: PermissionEntity): RequestResult<PermissionEntity> = try {
        val permissionDao = transaction {
            PermissionsEntity.new {
                name = permission.name
                permissionStatus = PermissionStatusMapper().toValue(permission.permissionStatus)
            }
        }

        val privileges = transaction {
            permission.privileges.map { privilege ->
                PrivilegesEntity.new {
                    value = PrivilegesMapper().toValue(privilege)
                    name = privilege.toString()
                }
            }
        }

        val permission = transaction {
            permissionDao.privileges = SizedCollection(privileges)

            permissionDao.toDataEntity()
        }

        RequestResult.Success(value = permission)

    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }

    override suspend fun deactivatePermission(id: String): RequestResult<PermissionEntity> = try {
        transaction {
            val permissionDao = PermissionsEntity.findById(id.toInt())
                    ?: throw Exception("Permission with $id ID not found.")

            permissionDao.permissionStatus = PermissionStatusMapper().toValue(PermissionStatus.INACTIVE)

            RequestResult.Success(permissionDao.toDataEntity())
        }
    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }
}