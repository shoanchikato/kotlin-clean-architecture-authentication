package zw.co.blu.domain.useCases.users

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import zw.co.blu.domain.model.users.User
import zw.co.blu.domain.model.users.UserStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.users.UserService

internal class GetUserTest{
    private val userServiceMock: UserService = mockk()

    private val role: String = "3"
    private val input: String = "1"

    private val output: User = User("", "", "", UserStatus.ACTIVE, role)

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<User> = RequestResult.Success(output)

        coEvery { userServiceMock.getUser(any()) } returns expected

        val sut = GetUser(userServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { userServiceMock.getUser(any()) }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<User> = RequestResult.Error(Exception("testing exception"))

        coEvery { userServiceMock.getUser(any()) } returns expected

        val sut = GetUser(userServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { userServiceMock.getUser(any()) }
    }
}