package zw.co.blu.exposed.sql.dao.repository.permissions

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.transactions.transaction
import zw.co.blu.data.datasource.sql.permissions.PermissionSqlDataSource
import zw.co.blu.data.model.permissions.PermissionEntity
import zw.co.blu.domain.model.permissions.PermissionStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.exposed.sql.dao.mapper.abilities.AbilitiesMapper
import zw.co.blu.exposed.sql.dao.mapper.permissions.PermissionEntityMapper
import zw.co.blu.exposed.sql.dao.mapper.permissions.PermissionStatusMapper
import zw.co.blu.exposed.sql.dao.model.permissions.PermissionModel
import zw.co.blu.exposed.sql.dao.table.abilities.AbilitiesEntity
import zw.co.blu.exposed.sql.dao.table.permissions.PermissionsEntity

class PermissionsRepositoryImpl(private val databaseConnection: Database) : PermissionSqlDataSource {

    override suspend fun getAllPermissions(): RequestResult<List<PermissionEntity>> = try {
        transaction {
            val permissionModels = PermissionsEntity.all()

            val permissionEntities = permissionModels.map { PermissionEntityMapper().mapFromModel(it.toModel()) }

            RequestResult.Success(value = permissionEntities)
        }
    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }

    override suspend fun createPermission(permission: PermissionEntity): RequestResult<PermissionEntity> = try {
        val result = transaction {
            PermissionsEntity.new {
                name = permission.name
                permissionStatus = PermissionStatusMapper().toValue(permission.permissionStatus)
            }
        }

        val abilities = transaction {
            permission.abilities.map { ability ->
                AbilitiesEntity.new {
                    value = AbilitiesMapper().toValue(ability)
                    name = ability.toString()
                }
            }
        }

        val permissionModel: PermissionModel = transaction {
            result.abilities = SizedCollection(abilities)

            result.toModel()
        }

        RequestResult.Success(value = PermissionEntityMapper().mapFromModel(permissionModel))

    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }

    override suspend fun deactivatePermission(id: String): RequestResult<PermissionEntity> = try {
        transaction {
            val permission = PermissionsEntity.findById(id.toInt())
                    ?: throw Exception("Permission with $id ID not found.")

            permission.permissionStatus = PermissionStatusMapper().toValue(PermissionStatus.INACTIVE)

            RequestResult.Success(PermissionEntityMapper().mapFromModel(permission.toModel()))

        }
    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }
}