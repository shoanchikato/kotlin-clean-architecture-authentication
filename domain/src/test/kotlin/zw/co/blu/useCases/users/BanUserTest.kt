package zw.co.blu.useCases.users

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import zw.co.blu.model.users.User
import zw.co.blu.model.users.UserStatus
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.users.UserService

internal class BanUserTest{
    private val userServiceMock: UserService = mockk()

    private val role: String = "3"
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