package zw.co.blu.exposed.sql.dao.repository.permissions

import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import zw.co.blu.data.datasource.sql.permissions.PermissionSqlDataSource
import zw.co.blu.data.model.permissions.PermissionEntity
import zw.co.blu.domain.model.abilities.Ability
import zw.co.blu.domain.model.permissions.PermissionStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.exposed.sql.dao.mapper.abilities.AbilitiesMapper
import zw.co.blu.exposed.sql.dao.mapper.permissions.PermissionStatusMapper
import zw.co.blu.exposed.sql.dao.tables.abilities.AbilitiesTable
import zw.co.blu.exposed.sql.dao.tables.permissions.PermissionsTable
import zw.co.blu.exposed.sql.dao.tables.permissionsAbilities.PermissionAbilitiesTable
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class PermissionsRepositoryImplTest {

    private val databaseConnection = Database.connect(
            url = "jdbc:h2:mem:regular;DB_CLOSE_DELAY=-1;",
            driver = "org.h2.Driver",
            user = "root",
            password = ""
    )

    private val repository: PermissionSqlDataSource = PermissionsRepositoryImpl(databaseConnection = databaseConnection)

    private val abilities = listOf(
            Ability.ACTIVATE,
            Ability.EDIT,
            Ability.READ,
    )

    private val permission = PermissionEntity(
            name = "BOOKS",
            permissionStatus = PermissionStatus.ACTIVE,
            abilities = abilities,
    )

    private fun loadDatabase() {
        val permissionId = PermissionsTable.insert {
            it[name] = permission.name
            it[permissionStatus] = PermissionStatusMapper().toValue(permission.permissionStatus)
        } get PermissionsTable.id

        permission.abilities.map { ability ->
            PermissionAbilitiesTable.insert {
                it[permission_id] = permissionId
                it[abilities_id] = AbilitiesMapper().toValue(ability)
            }
        }
    }

    init {
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.drop(PermissionsTable, AbilitiesTable, PermissionAbilitiesTable)
            SchemaUtils.create(PermissionsTable, AbilitiesTable, PermissionAbilitiesTable)
            loadDatabase()
        }
    }

    @Test
    fun `get all when DB has one item`() {
        val expected = RequestResult.Success(listOf(permission))

        runBlocking {
            assertEquals(expected, repository.getAllPermissions())
        }
    }

    @Test
    fun `create a permission`() {
        val expected = RequestResult.Success(permission)

        runBlocking {
            assertEquals(expected, repository.createPermission(permission))
        }
    }

    @Test
    fun `deactivate a permission`() {
        val deactivatedPermission = permission.copy(permissionStatus = PermissionStatus.INACTIVE)

        val input = "1"
        val expected = RequestResult.Success(deactivatedPermission)

        runBlocking {
            assertEquals(expected, repository.deactivatePermission(input))
        }
    }
}

//private fun loadAbilities() {
//    runBlocking {
//        Ability::class.nestedClasses.map { it ->
//            val objectInstance: Ability = it.objectInstance as Ability
//            val value: Int = AbilitiesMapper().toValue(objectInstance)
//
//            AbilitiesTable.insert {
//                it[AbilitiesTable.value] = value
//                it[AbilitiesTable.name] = objectInstance.toString()
//            }
//        }
//    }
//}