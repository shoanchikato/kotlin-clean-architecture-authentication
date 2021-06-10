package zw.co.blu.useCases.users

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import zw.co.blu.model.users.User
import zw.co.blu.model.users.UserDao
import zw.co.blu.model.users.UserStatus
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.users.UserService

internal class CreateUserTest {
    private val userServiceMock: UserService = mockk()

    private val role: String = "1"
    private val input: UserDao = UserDao(null, "", "", UserStatus.ACTIVE, role)

    private val output: User = User("1", "", "", UserStatus.ACTIVE, role)

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<User> = RequestResult.Success(output)

        coEvery { userServiceMock.createUser(any()) } returns expected

        val sut = CreateUser(userServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { userServiceMock.createUser(any()) }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<User> = RequestResult.Error(Exception("testing exception"))

        coEvery { userServiceMock.createUser(any()) } returns expected

        val sut = CreateUser(userServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { userServiceMock.createUser(any()) }
    }
}