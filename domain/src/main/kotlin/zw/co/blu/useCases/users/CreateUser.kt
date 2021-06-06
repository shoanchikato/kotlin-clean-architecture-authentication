package zw.co.blu.useCases.users

import zw.co.blu.model.User
import zw.co.blu.repository.users.UserRepository
import zw.co.blu.requestResult.RequestResult

class CreateUser(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: User): RequestResult {
        return userRepository.createUser(user)
    }
}