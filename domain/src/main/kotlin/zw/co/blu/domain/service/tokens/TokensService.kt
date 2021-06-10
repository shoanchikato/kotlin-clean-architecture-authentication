package zw.co.blu.domain.service.tokens

import zw.co.blu.domain.model.tokens.Tokens
import zw.co.blu.domain.requestResult.RequestResult

interface TokensService {
    suspend fun createRefreshToken(refreshToken: String): RequestResult<Tokens>
    suspend fun refreshTokensCleanUpCronJob(): RequestResult<Unit>
}