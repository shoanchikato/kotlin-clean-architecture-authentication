package zw.co.blu.exposed.sql.dao.repository.roles

import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.Test
import zw.co.blu.data.datasource.sql.roles.RoleSqlDataSource
import zw.co.blu.data.model.roles.RoleDaoEntity
import zw.co.blu.data.model.roles.RoleEditDaoEntity
import zw.co.blu.data.model.roles.RoleEntity
import zw.co.blu.domain.model.roles.RoleStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.exposed.sql.dao.repository.TestDependencies
import kotlin.test.assertEquals

internal class RoleRepositoryImplTest {

    private val databaseConnection = TestDependencies.initDatabaseConnection()

    private val repository: RoleSqlDataSource = RoleRepositoryImpl(databaseConnection = databaseConnection)

    private val input: RoleEntity = TestDependencies.roleInput
    private val createInput: RoleDaoEntity = TestDependencies.roleCreateInput
    private val editInput: RoleEditDaoEntity = TestDependencies.roleEditInput
    private val editOutput: RoleEntity = TestDependencies.roleEditOutput
    private val output: RoleEntity = TestDependencies.roleOutput

    init {
        transaction {
            TestDependencies.loadRoles()
        }
    }

    @Test
    fun `create a role`() {
        val output = output
        val expected = RequestResult.Success(output)

        val input = createInput

        runBlocking {
            assertEquals(expected, repository.createRole(input))
        }
    }

    @Test
    fun `get role by id`() {
        val expected = RequestResult.Success(input)
        val input = "1"

        runBlocking {
            assertEquals(expected, repository.getRoleById(input))
        }
    }

    @Test
    fun `get all roles`() {
        val expected = RequestResult.Success(listOf(input))

        runBlocking {
            assertEquals(expected, repository.getAllRoles())
        }
    }

    @Test
    fun `edit a role`() {
        val inputValue = editInput

        val inputId = "1"
        val expected = RequestResult.Success(editOutput)

        runBlocking {
            assertEquals(expected, repository.editRole(inputId, inputValue))
        }
    }

    @Test
    fun `deactivate a Role`() {
        val inputId: String = "1"

        val expected = RequestResult.Success(input.copy(roleStatus = RoleStatus.INACTIVE))

        runBlocking {
            assertEquals(expected, repository.deactivateRole(inputId))
        }
    }
}