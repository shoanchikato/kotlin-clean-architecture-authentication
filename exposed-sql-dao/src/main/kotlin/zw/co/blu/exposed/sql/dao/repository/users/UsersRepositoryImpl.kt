package zw.co.blu.exposed.sql.dao.repository.users

import org.jetbrains.exposed.sql.Database
import zw.co.blu.data.datasource.sql.users.UserSqlDataSource
import zw.co.blu.data.model.users.UserDaoEntity
import zw.co.blu.data.model.users.UserEditDaoEntity
import zw.co.blu.data.model.users.UserEntity
import zw.co.blu.domain.requestResult.RequestResult

class UsersRepositoryImpl(private val databaseConnection: Database): UserSqlDataSource {
    override suspend fun createUser(user: UserDaoEntity): RequestResult<UserEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun editUser(id: String, user: UserEditDaoEntity): RequestResult<UserEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(id: String): RequestResult<UserEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun activateUser(id: String): RequestResult<UserEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun deactivateUser(id: String): RequestResult<UserEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun suspendUser(id: String): RequestResult<UserEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun banUser(id: String): RequestResult<UserEntity> {
        TODO("Not yet implemented")
    }
}