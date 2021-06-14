package zw.co.blu.exposed.sql.dao.repository.permissions

import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import zw.co.blu.data.datasource.sql.permissions.PermissionSqlDataSource
import zw.co.blu.domain.model.permissions.PermissionStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.exposed.sql.dao.repository.TestDependencies
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class PermissionsRepositoryImplTest {

    private val databaseConnection = TestDependencies.initDatabaseConnection()

    private val repository: PermissionSqlDataSource = PermissionsRepositoryImpl(databaseConnection = databaseConnection)

    private val input = TestDependencies.permissionInput

    init {
        transaction {
            TestDependencies.loadPermissions()
        }
    }

    @Test
    fun `get all when DB has one item`() {
        val expected = RequestResult.Success(listOf(input))

        runBlocking {
            assertEquals(expected, repository.getAllPermissions())
        }
    }

    @Test
    fun `create a permission`() {
        val output = input.copy(id = "2")
        val expected = RequestResult.Success(output)

        runBlocking {
            assertEquals(expected, repository.createPermission(input))
        }
    }

    @Test
    fun `deactivate a permission`() {
        val deactivatedPermission = input.copy(permissionStatus = PermissionStatus.INACTIVE)

        val input = "1"
        val expected = RequestResult.Success(deactivatedPermission)

        runBlocking {
            assertEquals(expected, repository.deactivatePermission(input))
        }
    }
}

//private fun loadPrivileges() {
//    runBlocking {
//        Privilege::class.nestedClasses.map { it ->
//            val objectInstance: Privilege = it.objectInstance as Privilege
//            val value: Int = PrivilegesMapper().toValue(objectInstance)
//
//            PrivilegesTable.insert {
//                it[PrivilegesTable.value] = value
//                it[PrivilegesTable.name] = objectInstance.toString()
//            }
//        }
//    }
//}