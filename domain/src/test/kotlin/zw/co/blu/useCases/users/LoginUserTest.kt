package zw.co.blu.useCases.users

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import zw.co.blu.model.Credentials
import zw.co.blu.model.Tokens
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.authentication.AuthenticationService

internal class LoginUserTest {
    private val authenticationServiceMock: AuthenticationService = mockk()

    private val input: Credentials = Credentials("username", "password")

    private val output: Tokens = Tokens("access-token", "refresh-token")

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<Tokens> = RequestResult.Success(output)

        coEvery { authenticationServiceMock.loginUser(any()) } returns expected

        val sut = LoginUser(authenticationServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { authenticationServiceMock.loginUser(any()) }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<Tokens> = RequestResult.Error(Exception("testing exception"))

        coEvery { authenticationServiceMock.loginUser(any()) } returns expected

        val sut = LoginUser(authenticationServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { authenticationServiceMock.loginUser(any()) }
    }
}