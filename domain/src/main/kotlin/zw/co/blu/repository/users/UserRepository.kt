package zw.co.blu.repository.users

import zw.co.blu.model.User
import zw.co.blu.model.UserDao
import zw.co.blu.requestResult.RequestResult

interface UserRepository {
    suspend fun createUser(user: User): RequestResult
    suspend fun editUser(id: String, user: UserDao): RequestResult
    suspend fun getUser(id: String): RequestResult
    suspend fun activateUser(id: String): RequestResult
    suspend fun deactivateUser(id: String): RequestResult
    suspend fun suspendUser(id: String): RequestResult
    suspend fun banUser(id: String): RequestResult
}