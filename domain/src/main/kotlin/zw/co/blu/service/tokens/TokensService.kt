package zw.co.blu.service.tokens

import zw.co.blu.model.tokens.Tokens
import zw.co.blu.requestResult.RequestResult

interface TokensService {
    suspend fun createRefreshToken(refreshToken: String): RequestResult<Tokens>
    suspend fun refreshTokensCleanUpCronJob(): RequestResult<Unit>
}