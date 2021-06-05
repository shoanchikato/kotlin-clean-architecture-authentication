package zw.co.blu.repository.users

import zw.co.blu.model.User
import zw.co.blu.requestResult.RequestResult

interface UserRepository {
    suspend fun createUser(user: User): RequestResult
    suspend fun editUser(user: User): RequestResult
    suspend fun activateUser(user: User): RequestResult
    suspend fun deactivateUser(user: User): RequestResult
    suspend fun suspendUser(user: User): RequestResult
    suspend fun banUser(user: User): RequestResult
}