package zw.co.blu.useCases.users

import zw.co.blu.model.UserDao
import zw.co.blu.repository.users.UserRepository
import zw.co.blu.requestResult.RequestResult

class EditUser(private val userRepository: UserRepository) {
    suspend operator fun invoke(id: String, user: UserDao): RequestResult {
        return userRepository.editUser(id, user)
    }
}