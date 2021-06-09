package zw.co.blu.useCases.users

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.authentication.AuthenticationService

internal class LogoutUserTest {
    private val authenticationServiceMock: AuthenticationService = mockk()

    private val input: String = "access-token"

    private val output: Unit = Unit

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<Unit> = RequestResult.Success(output)

        coEvery { authenticationServiceMock.logoutUser(any()) } returns expected

        val sut = LogoutUser(authenticationServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { authenticationServiceMock.logoutUser(any()) }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<Unit> = RequestResult.Error(Exception("testing exception"))

        coEvery { authenticationServiceMock.logoutUser(any()) } returns expected

        val sut = LogoutUser(authenticationServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { authenticationServiceMock.logoutUser(any()) }
    }
}