package zw.co.blu.useCases.users

import zw.co.blu.model.users.User
import zw.co.blu.model.users.UserEditDao
import zw.co.blu.service.users.UserService
import zw.co.blu.requestResult.RequestResult

class EditUser(private val userService: UserService) {
    suspend operator fun invoke(id: String, user: UserEditDao): RequestResult<User> {
        return userService.editUser(id, user)
    }
}