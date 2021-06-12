package zw.co.blu.exposed.sql.dao.repository.permissions

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import zw.co.blu.data.datasource.sql.permissions.PermissionSqlDataSource
import zw.co.blu.data.model.permissions.PermissionEntity
import zw.co.blu.domain.model.permissions.PermissionStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.exposed.sql.dao.mapper.abilities.AbilitiesMapper
import zw.co.blu.exposed.sql.dao.mapper.permissions.PermissionEntityMapper
import zw.co.blu.exposed.sql.dao.mapper.permissions.PermissionStatusMapper
import zw.co.blu.exposed.sql.dao.model.permissions.PermissionModel
import zw.co.blu.exposed.sql.dao.tables.permissions.PermissionsTable
import zw.co.blu.exposed.sql.dao.tables.permissions.toPermissionModel
import zw.co.blu.exposed.sql.dao.tables.permissionsAbilities.PermissionAbilitiesTable
import zw.co.blu.exposed.sql.dao.tables.roles.toPermissions

class PermissionsRepositoryImpl(private val databaseConnection: Database) : PermissionSqlDataSource {

    override suspend fun getAllPermissions(): RequestResult<List<PermissionEntity>> = try {
        transaction {
            val permissionModels = PermissionsTable.selectAll().map {
                it.toPermissionModel()
            }

            val permissionEntities = permissionModels.map { PermissionEntityMapper().mapFromModel(it) }

            RequestResult.Success(value = permissionEntities)
        }
    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }

    override suspend fun createPermission(permission: PermissionEntity): RequestResult<PermissionEntity> = try {
        transaction {
            val permissionId = PermissionsTable.insert {
                it[name] = permission.name
                it[permissionStatus] = PermissionStatusMapper().toValue(permission.permissionStatus)
            } get PermissionsTable.id

            permission.abilities.forEach { ability ->
                PermissionAbilitiesTable.insert {
                    it[permission_id] = permissionId
                    it[abilities_id] = AbilitiesMapper().toValue(ability)
                }
            }

            val permissionModel: PermissionModel = PermissionsTable.select { PermissionsTable.id eq permissionId }.single().toPermissionModel()

            RequestResult.Success(value = PermissionEntityMapper().mapFromModel(permissionModel))
        }
    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }

    override suspend fun deactivatePermission(id: String): RequestResult<PermissionEntity> = try {
        transaction {
            PermissionsTable.update({ PermissionsTable.id eq id.toInt() }) {
                it[permissionStatus] = PermissionStatusMapper().toValue(PermissionStatus.INACTIVE)
            }

            val permissionModel: PermissionModel = PermissionsTable.select { PermissionsTable.id eq id.toInt() }.single().toPermissionModel()

            RequestResult.Success(value = PermissionEntityMapper().mapFromModel(permissionModel))
        }
    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }
}