package zw.co.blu.useCases.tokens

import zw.co.blu.model.tokens.Tokens
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.tokens.TokensService

class CreateRefreshTokens(private val tokensService: TokensService) {
    suspend operator fun invoke(refreshToken: String): RequestResult<Tokens> {
        return tokensService.createRefreshToken(refreshToken)
    }
}