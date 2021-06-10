package zw.co.blu.domain.useCases.users

import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.authentication.AuthenticationService

class AuthenticateUser(private val authenticationService: AuthenticationService) {
    suspend operator fun invoke(accessToken: String): RequestResult<Unit> {
        return authenticationService.authenticateUser(accessToken)
    }
}