package zw.co.blu.domain.repository.tokens

import zw.co.blu.domain.model.tokens.Tokens
import zw.co.blu.domain.requestResult.RequestResult

interface TokensRepository {
    suspend fun saveRefreshToken(refreshToken: String): RequestResult<Tokens>
    suspend fun deleteRefreshToken(refreshToken: String): RequestResult<Boolean>
}