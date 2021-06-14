package zw.co.blu.domain.repository.users

import zw.co.blu.domain.model.users.User
import zw.co.blu.domain.model.users.UserDao
import zw.co.blu.domain.model.users.UserEditDao
import zw.co.blu.domain.requestResult.RequestResult

interface UserRepository {
    suspend fun createUser(user: UserDao): RequestResult<User>
    suspend fun editUser(id: String, user: UserEditDao): RequestResult<User>
    suspend fun getUserById(id: String): RequestResult<User>
    suspend fun activateUser(id: String): RequestResult<User>
    suspend fun deactivateUser(id: String): RequestResult<User>
    suspend fun suspendUser(id: String): RequestResult<User>
    suspend fun banUser(id: String): RequestResult<User>
}