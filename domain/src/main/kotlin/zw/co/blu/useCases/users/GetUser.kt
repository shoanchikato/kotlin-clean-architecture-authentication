package zw.co.blu.useCases.users

import zw.co.blu.model.users.User
import zw.co.blu.service.users.UserService
import zw.co.blu.requestResult.RequestResult

class GetUser(private val userService: UserService) {
    suspend operator fun invoke(id: String): RequestResult<User> {
        return userService.getUser(id)
    }
}