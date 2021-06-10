package zw.co.blu.domain.useCases.tokens

import zw.co.blu.domain.model.tokens.Tokens
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.tokens.TokensService

class CreateRefreshTokens(private val tokensService: TokensService) {
    suspend operator fun invoke(refreshToken: String): RequestResult<Tokens> {
        return tokensService.createRefreshToken(refreshToken)
    }
}