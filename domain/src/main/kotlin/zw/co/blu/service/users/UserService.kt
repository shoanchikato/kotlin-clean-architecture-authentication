package zw.co.blu.service.users

import zw.co.blu.model.User
import zw.co.blu.model.UserDao
import zw.co.blu.model.UserEditDao
import zw.co.blu.requestResult.RequestResult

interface UserService {
    suspend fun createUser(user: UserDao): RequestResult<User>
    suspend fun editUser(id: String, user: UserEditDao): RequestResult<User>
    suspend fun getUser(id: String): RequestResult<User>
    suspend fun activateUser(id: String): RequestResult<User>
    suspend fun deactivateUser(id: String): RequestResult<User>
    suspend fun suspendUser(id: String): RequestResult<User>
    suspend fun banUser(id: String): RequestResult<User>
}