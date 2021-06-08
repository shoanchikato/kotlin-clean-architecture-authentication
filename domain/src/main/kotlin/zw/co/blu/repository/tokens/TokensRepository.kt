package zw.co.blu.repository.tokens

import zw.co.blu.model.Tokens
import zw.co.blu.requestResult.RequestResult

interface TokensRepository {
    suspend fun saveRefreshToken(refreshToken: String): RequestResult<Tokens>
    suspend fun deleteRefreshToken(refreshToken: String): RequestResult<Boolean>
}