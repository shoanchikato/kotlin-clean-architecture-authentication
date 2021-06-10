package zw.co.blu.datasource.sql.users

import zw.co.blu.model.users.UserDaoEntity
import zw.co.blu.model.users.UserEditDaoEntity
import zw.co.blu.model.users.UserEntity
import zw.co.blu.requestResult.RequestResult

interface UserSqlDataSource {
    suspend fun createUser(user: UserDaoEntity): RequestResult<UserEntity>
    suspend fun editUser(id: String, user: UserEditDaoEntity): RequestResult<UserEntity>
    suspend fun getUser(id: String): RequestResult<UserEntity>
    suspend fun activateUser(id: String): RequestResult<UserEntity>
    suspend fun deactivateUser(id: String): RequestResult<UserEntity>
    suspend fun suspendUser(id: String): RequestResult<UserEntity>
    suspend fun banUser(id: String): RequestResult<UserEntity>
}