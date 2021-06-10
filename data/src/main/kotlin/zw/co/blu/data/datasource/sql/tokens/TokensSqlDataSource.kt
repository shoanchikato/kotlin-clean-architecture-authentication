package zw.co.blu.data.datasource.sql.tokens

import zw.co.blu.data.model.tokens.TokensEntity
import zw.co.blu.domain.requestResult.RequestResult

interface TokensSqlDataSource {
    suspend fun saveRefreshToken(refreshToken: String): RequestResult<TokensEntity>
    suspend fun deleteRefreshToken(refreshToken: String): RequestResult<Boolean>
}