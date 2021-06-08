package zw.co.blu.service.tokens

import zw.co.blu.model.Tokens
import zw.co.blu.requestResult.RequestResult

interface TokensService {
    suspend fun createRefreshToken(refreshToken: String): RequestResult<Tokens>
    suspend fun refreshTokensCleanUpCronJob(): Unit
    suspend fun saveRefreshToken(refreshToken: String): RequestResult<Tokens>
    suspend fun deleteRefreshToken(refreshToken: String): RequestResult<Boolean>
}