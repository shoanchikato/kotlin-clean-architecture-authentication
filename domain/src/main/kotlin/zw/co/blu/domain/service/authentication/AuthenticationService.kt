package zw.co.blu.domain.service.authentication

import zw.co.blu.domain.model.credentials.Credentials
import zw.co.blu.domain.model.tokens.Tokens
import zw.co.blu.domain.requestResult.RequestResult

interface AuthenticationService {
    fun authenticateUser(token: String): RequestResult<Unit>
    fun loginUser(credentials: Credentials): RequestResult<Tokens>
    fun logoutUser(accessToken: String): RequestResult<Unit>
}