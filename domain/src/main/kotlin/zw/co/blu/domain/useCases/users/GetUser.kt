package zw.co.blu.domain.useCases.users

import zw.co.blu.domain.model.users.User
import zw.co.blu.domain.service.users.UserService
import zw.co.blu.domain.requestResult.RequestResult

class GetUser(private val userService: UserService) {
    suspend operator fun invoke(id: String): RequestResult<User> {
        return userService.getUser(id)
    }
}