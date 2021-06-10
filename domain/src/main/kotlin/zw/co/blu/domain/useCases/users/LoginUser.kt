package zw.co.blu.domain.useCases.users

import zw.co.blu.domain.model.credentials.Credentials
import zw.co.blu.domain.model.tokens.Tokens
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.authentication.AuthenticationService

class LoginUser(private val authenticationService: AuthenticationService) {
    suspend operator fun invoke(credentials: Credentials): RequestResult<Tokens> {
        return authenticationService.loginUser(credentials)
    }
}