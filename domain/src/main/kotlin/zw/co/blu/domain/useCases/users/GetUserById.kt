package zw.co.blu.domain.useCases.users

import zw.co.blu.domain.model.users.User
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.users.UserService

class GetUserById(private val userService: UserService) {
    suspend operator fun invoke(id: String): RequestResult<User> {
        return userService.getUserById(id)
    }
}