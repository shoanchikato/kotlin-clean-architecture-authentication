package zw.co.blu.useCases.users

import zw.co.blu.model.credentials.Credentials
import zw.co.blu.model.tokens.Tokens
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.authentication.AuthenticationService

class LoginUser(private val authenticationService: AuthenticationService) {
    suspend operator fun invoke(credentials: Credentials): RequestResult<Tokens> {
        return authenticationService.loginUser(credentials)
    }
}