package zw.co.blu.datasource.nosql.tokens

import zw.co.blu.model.tokens.TokensEntity
import zw.co.blu.requestResult.RequestResult

interface TokensNoSqlDataSource {
    suspend fun saveRefreshToken(refreshToken: String): RequestResult<TokensEntity>
    suspend fun deleteRefreshToken(refreshToken: String): RequestResult<Boolean>
}