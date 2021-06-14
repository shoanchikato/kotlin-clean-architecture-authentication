package zw.co.blu.domain.useCases.tokens

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import zw.co.blu.domain.model.tokens.Tokens
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.tokens.TokensService

internal class CreateRefreshTokensTest {
    private val tokenServiceMock: TokensService = mockk()

    private val input: String = "refresh-token"

    private val output: Tokens = Tokens("access-token", "refresh-token")

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<Tokens> = RequestResult.Success(output)

        coEvery { tokenServiceMock.createRefreshToken(any()) } returns expected

        val sut = CreateRefreshTokens(tokenServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { tokenServiceMock.createRefreshToken(any()) }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<Tokens> = RequestResult.Error(Exception("testing exception"))

        coEvery { tokenServiceMock.createRefreshToken(any()) } returns expected

        val sut = CreateRefreshTokens(tokenServiceMock)

        runBlocking { assertEquals(expected, sut.invoke(input)) }

        coVerify { tokenServiceMock.createRefreshToken(any()) }
    }
}