package zw.co.blu.domain.useCases.users

import zw.co.blu.domain.model.users.User
import zw.co.blu.domain.model.users.UserEditDao
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.domain.service.users.UserService

class EditUser(private val userService: UserService) {
    suspend operator fun invoke(id: String, user: UserEditDao): RequestResult<User> {
        return userService.editUser(id, user)
    }
}