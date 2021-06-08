package zw.co.blu.useCases.users

import zw.co.blu.model.User
import zw.co.blu.service.users.UserService
import zw.co.blu.requestResult.RequestResult

class CreateUser(private val userService: UserService) {
    suspend operator fun invoke(user: User): RequestResult<User> {
        return userService.createUser(user)
    }
}