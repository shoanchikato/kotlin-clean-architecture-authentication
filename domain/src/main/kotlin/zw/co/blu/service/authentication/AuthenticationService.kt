package zw.co.blu.service.authentication

import zw.co.blu.model.Credentials
import zw.co.blu.model.Tokens
import zw.co.blu.requestResult.RequestResult

interface AuthenticationService {
    fun authenticateUser(token: String): RequestResult<Unit>
    fun loginUser(credentials: Credentials): RequestResult<Tokens>
    fun logoutUser(accessToken: String): RequestResult<Unit>
}