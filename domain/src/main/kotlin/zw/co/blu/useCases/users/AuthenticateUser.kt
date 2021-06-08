package zw.co.blu.useCases.users

import zw.co.blu.model.Tokens
import zw.co.blu.model.User
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.authentication.AuthenticationService

class AuthenticateUser(private val authenticationService: AuthenticationService) {
    suspend operator fun invoke(accessToken: String): RequestResult<Unit> {
        return authenticationService.authenticateUser(accessToken)
    }
}