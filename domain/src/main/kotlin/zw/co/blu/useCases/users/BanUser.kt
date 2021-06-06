package zw.co.blu.useCases.users

import zw.co.blu.repository.users.UserRepository
import zw.co.blu.requestResult.RequestResult

class BanUser(private val userRepository: UserRepository) {
    suspend operator fun invoke(id: String): RequestResult {
        return userRepository.banUser(id)
    }
}