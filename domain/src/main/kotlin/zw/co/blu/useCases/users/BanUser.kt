package zw.co.blu.useCases.users

import zw.co.blu.model.User
import zw.co.blu.service.users.UserService
import zw.co.blu.requestResult.RequestResult

class BanUser(private val userService: UserService) {
    suspend operator fun invoke(id: String): RequestResult<User> {
        return userService.banUser(id)
    }
}