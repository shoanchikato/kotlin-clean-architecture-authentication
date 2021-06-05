package zw.co.blu.repository.users

import zw.co.blu.model.User
import zw.co.blu.requestState.RequestResult

interface UserRepository {
    suspend fun createUser(user: User): RequestResult
    suspend fun editUser(user: User): RequestResult
    suspend fun activate(user: User): RequestResult
    suspend fun inactivate(user: User): RequestResult
    suspend fun suspend(user: User): RequestResult
    suspend fun ban(user: User): RequestResult
}