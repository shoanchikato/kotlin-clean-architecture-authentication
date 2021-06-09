package zw.co.blu.useCases.tokens

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.tokens.TokensService

internal class CleanUpRefreshTokensTest {
    private val tokenServiceMock: TokensService = mockk()

    private val input: String = "refresh-token"

    private val output: Unit = Unit

    @Test
    fun `it should return successful response`() {

        val expected: RequestResult.Success<Unit> = RequestResult.Success(output)

        coEvery { tokenServiceMock.refreshTokensCleanUpCronJob() } returns expected

        val sut = CleanUpRefreshTokens(tokenServiceMock)

        runBlocking { assertEquals(expected, sut.invoke()) }

        coVerify { tokenServiceMock.refreshTokensCleanUpCronJob() }
    }

    @Test
    fun `it should return error response`() {

        val expected: RequestResult.Error<Unit> = RequestResult.Error(Exception("testing exception"))

        coEvery { tokenServiceMock.refreshTokensCleanUpCronJob() } returns expected

        val sut = CleanUpRefreshTokens(tokenServiceMock)

        runBlocking { assertEquals(expected, sut.invoke()) }

        coVerify { tokenServiceMock.refreshTokensCleanUpCronJob() }
    }
}