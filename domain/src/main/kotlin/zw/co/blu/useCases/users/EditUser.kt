package zw.co.blu.useCases.users

import zw.co.blu.model.User
import zw.co.blu.model.UserDao
import zw.co.blu.service.users.UserService
import zw.co.blu.requestResult.RequestResult

class EditUser(private val userService: UserService) {
    suspend operator fun invoke(id: String, user: UserDao): RequestResult<User> {
        return userService.editUser(id, user)
    }
}