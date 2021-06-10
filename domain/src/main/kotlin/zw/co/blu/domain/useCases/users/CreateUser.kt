package zw.co.blu.domain.useCases.users

import zw.co.blu.domain.model.users.User
import zw.co.blu.domain.model.users.UserDao
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.users.UserService

class CreateUser(private val userService: UserService) {
    suspend operator fun invoke(user: UserDao): RequestResult<User> {
        return userService.createUser(user)
    }
}