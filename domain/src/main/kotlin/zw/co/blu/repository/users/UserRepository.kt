package zw.co.blu.repository.users

import zw.co.blu.model.User
import zw.co.blu.model.UserDao
import zw.co.blu.requestResult.RequestResult

interface UserRepository {
    suspend fun createUser(user: User): RequestResult<User>
    suspend fun editUser(id: String, user: UserDao): RequestResult<User>
    suspend fun getUser(id: String): RequestResult<User>
    suspend fun activateUser(id: String): RequestResult<User>
    suspend fun deactivateUser(id: String): RequestResult<User>
    suspend fun suspendUser(id: String): RequestResult<User>
    suspend fun banUser(id: String): RequestResult<User>
}