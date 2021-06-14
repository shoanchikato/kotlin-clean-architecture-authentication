package zw.co.blu.domain.useCases.users

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import zw.co.blu.domain.model.roles.Role
import zw.co.blu.domain.model.roles.RoleStatus
import zw.co.blu.domain.model.users.User
import zw.co.blu.domain.model.users.UserEditDao
import zw.co.blu.domain.model.users.UserStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.users.UserService

internal class EditUserTest {
    private val userServiceMock: UserService = mockk()

    private val inputId: String = "1"
    private val role: Role = Role("1", "MANAGER", RoleStatus.ACTIVE, listOf())
    private val roleId: String = "1"
    private val inputValue: UserEditDao = UserEditDao(null, "", "", UserStatus.ACTIVE, roleId)

    private val output: User = User("1", "", "", UserStatus.ACTIVE, role)

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<User> = RequestResult.Success(output)

        coEvery { userServiceMock.editUser(any(), any()) } returns expected

        val sut = EditUser(userServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(inputId, inputValue)) }

        coVerify { userServiceMock.editUser(any(), any()) }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<User> = RequestResult.Error(Exception("testing exception"))

        coEvery { userServiceMock.editUser(any(), any()) } returns expected

        val sut = EditUser(userServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(inputId, inputValue)) }

        coVerify { userServiceMock.editUser(any(), any()) }
    }
}