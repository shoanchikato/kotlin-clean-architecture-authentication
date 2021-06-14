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
import zw.co.blu.domain.model.users.UserStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.users.UserService

internal class BanUserTest {
    private val userServiceMock: UserService = mockk()

    private val role: Role = Role("1", "MANAGER", RoleStatus.ACTIVE, listOf())
    private val input: String = "1"

    private val output: User = User("", "", "", UserStatus.BANNED, role)

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<User> = RequestResult.Success(output)

        coEvery { userServiceMock.banUser(any()) } returns expected

        val sut = BanUser(userServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { userServiceMock.banUser(any()) }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<User> = RequestResult.Error(Exception("testing exception"))

        coEvery { userServiceMock.banUser(any()) } returns expected

        val sut = BanUser(userServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { userServiceMock.banUser(any()) }
    }
}