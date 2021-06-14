package zw.co.blu.exposed.sql.dao.repository.users

import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import zw.co.blu.data.datasource.sql.users.UserSqlDataSource
import zw.co.blu.data.model.users.UserDaoEntity
import zw.co.blu.data.model.users.UserEntity
import zw.co.blu.domain.model.users.UserStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.exposed.sql.dao.repository.TestDependencies

internal class UserRepositoryImplTest {

    private val databaseConnection = TestDependencies.initDatabaseConnection()

    private val repository: UserSqlDataSource = UserRepositoryImpl(databaseConnection = databaseConnection)

    private val userInput: UserDaoEntity = TestDependencies.userInput
    private val output: UserEntity = TestDependencies.userOutput

    private val userEditInput = TestDependencies.userEditInput
    private val userEditOutput = TestDependencies.userEditOutput

    init {
        transaction {
            TestDependencies.loadUsers()
        }
    }

    @Test
    fun `create a user`() {
        val output = output
        val expected = RequestResult.Success(output)

        val input = userInput

        runBlocking {
            assertEquals(expected, repository.createUser(input))
        }
    }

    @Test
    fun `edit a user`() {
        val output = userEditOutput
        val expected = RequestResult.Success(output)

        val inputId = userEditInput.id.toString()
        val inputValue = userEditInput

        runBlocking {
            assertEquals(expected, repository.editUser(inputId, inputValue))
        }
    }

    @Test
    fun `get user by Id`() {
        val output = output.copy(id = "1")
        val expected = RequestResult.Success(output)

        val inputId = "1"

        runBlocking {
            assertEquals(expected, repository.getUserById(inputId))
        }
    }

    @Test
    fun `activate a user`() {
        val output = output.copy(id = "1", userStatus = UserStatus.ACTIVE)
        val expected = RequestResult.Success(output)

        val inputId = "1"

        runBlocking {
            assertEquals(expected, repository.activateUser(inputId))
        }
    }

    @Test
    fun `deactivate a user`() {
        val output = output.copy(id = "1", userStatus = UserStatus.INACTIVE)
        val expected = RequestResult.Success(output)

        val inputId = "1"

        runBlocking {
            assertEquals(expected, repository.deactivateUser(inputId))
        }
    }

    @Test
    fun `suspend a user`() {
        val output = output.copy(id = "1", userStatus = UserStatus.SUSPENDED)
        val expected = RequestResult.Success(output)

        val inputId = "1"

        runBlocking {
            assertEquals(expected, repository.suspendUser(inputId))
        }
    }

    @Test
    fun `ban a user`() {
        val output = output.copy(id = "1", userStatus = UserStatus.BANNED)
        val expected = RequestResult.Success(output)

        val inputId = "1"

        runBlocking {
            assertEquals(expected, repository.banUser(inputId))
        }
    }
}