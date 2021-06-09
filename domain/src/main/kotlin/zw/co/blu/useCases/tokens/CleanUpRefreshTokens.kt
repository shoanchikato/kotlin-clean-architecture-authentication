package zw.co.blu.useCases.tokens

import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.tokens.TokensService

class CleanUpRefreshTokens(private val tokensService: TokensService) {
    suspend operator fun invoke(): RequestResult<Unit> {
        return tokensService.refreshTokensCleanUpCronJob()
    }
}