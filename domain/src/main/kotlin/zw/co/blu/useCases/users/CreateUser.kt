package zw.co.blu.useCases.users

import zw.co.blu.model.users.User
import zw.co.blu.model.users.UserDao
import zw.co.blu.requestResult.RequestResult
import zw.co.blu.service.users.UserService

class CreateUser(private val userService: UserService) {
    suspend operator fun invoke(user: UserDao): RequestResult<User> {
        return userService.createUser(user)
    }
}