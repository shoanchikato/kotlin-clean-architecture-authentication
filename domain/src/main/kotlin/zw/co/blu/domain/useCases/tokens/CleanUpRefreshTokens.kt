package zw.co.blu.domain.useCases.tokens

import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.tokens.TokensService

class CleanUpRefreshTokens(private val tokensService: TokensService) {
    suspend operator fun invoke(): RequestResult<Unit> {
        return tokensService.refreshTokensCleanUpCronJob()
    }
}