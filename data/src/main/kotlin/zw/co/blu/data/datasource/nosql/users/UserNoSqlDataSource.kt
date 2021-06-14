package zw.co.blu.data.datasource.nosql.users

import zw.co.blu.data.model.users.UserDaoEntity
import zw.co.blu.data.model.users.UserEditDaoEntity
import zw.co.blu.data.model.users.UserEntity
import zw.co.blu.domain.requestResult.RequestResult

interface UserNoSqlDataSource {
    suspend fun createUser(user: UserDaoEntity): RequestResult<UserEntity>
    suspend fun editUser(id: String, user: UserEditDaoEntity): RequestResult<UserEntity>
    suspend fun getUserById(id: String): RequestResult<UserEntity>
    suspend fun activateUser(id: String): RequestResult<UserEntity>
    suspend fun deactivateUser(id: String): RequestResult<UserEntity>
    suspend fun suspendUser(id: String): RequestResult<UserEntity>
    suspend fun banUser(id: String): RequestResult<UserEntity>
}