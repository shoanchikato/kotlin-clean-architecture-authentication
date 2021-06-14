package zw.co.blu.exposed.sql.dao.repository.users

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import zw.co.blu.data.datasource.sql.users.UserSqlDataSource
import zw.co.blu.data.model.users.UserDaoEntity
import zw.co.blu.data.model.users.UserEditDaoEntity
import zw.co.blu.data.model.users.UserEntity
import zw.co.blu.domain.model.users.UserStatus
import zw.co.blu.domain.requestResult.RequestResult
import zw.co.blu.exposed.sql.dao.mapper.users.UserStatusMapper
import zw.co.blu.exposed.sql.dao.table.roles.RolesEntity
import zw.co.blu.exposed.sql.dao.table.users.UsersEntity

class UserRepositoryImpl(private val databaseConnection: Database) : UserSqlDataSource {

    override suspend fun createUser(user: UserDaoEntity): RequestResult<UserEntity> = try {
        transaction {
            val roleDao = RolesEntity.findById(user.roleId.toInt())
                    ?: throw Exception("Error creating user, default role not found")

            val userDao = transaction {
                UsersEntity.new {
                    username = user.username
                    email = user.email
                    userStatus = UserStatusMapper().toValue(UserStatus.ACTIVE)
                    role = roleDao
                }
            }

            RequestResult.Success(value = userDao.toDataEntity())
        }

    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }

    override suspend fun editUser(id: String, user: UserEditDaoEntity): RequestResult<UserEntity> = try {
        transaction {
            val userDao = transaction {
                UsersEntity.findById(id.toInt())

            } ?: throw Exception("User with $id ID not found")

            val roleDao = user.roleId?.let { roleId ->
                transaction {
                    RolesEntity.findById(roleId.toInt())
                } ?: throw Exception("User with $id ID not found")
            }

            userDao.username = user.username ?: userDao.username
            userDao.email = user.email ?: userDao.email
            userDao.userStatus = user.userStatus?.let { UserStatusMapper().toValue(it) } ?: userDao.userStatus
            userDao.username = user.username ?: userDao.username
            userDao.role = roleDao ?: userDao.role

            RequestResult.Success(value = userDao.toDataEntity())
        }
    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }

    override suspend fun getUserById(id: String): RequestResult<UserEntity> = try {
        transaction {
            val userDao = UsersEntity.findById(id.toInt()) ?: throw Exception("User with $id ID not found")

            RequestResult.Success(userDao.toDataEntity())
        }
    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }

    override suspend fun activateUser(id: String): RequestResult<UserEntity>  = try {
        transaction {
            val userDao = UsersEntity.findById(id.toInt()) ?: throw Exception("User with $id ID not found")

            userDao.userStatus = UserStatusMapper().toValue(UserStatus.ACTIVE)

            RequestResult.Success(userDao.toDataEntity())
        }
    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }

    override suspend fun deactivateUser(id: String): RequestResult<UserEntity> = try {
        transaction {
            val userDao = UsersEntity.findById(id.toInt()) ?: throw Exception("User with $id ID not found")

            userDao.userStatus = UserStatusMapper().toValue(UserStatus.INACTIVE)

            RequestResult.Success(userDao.toDataEntity())
        }
    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }

    override suspend fun suspendUser(id: String): RequestResult<UserEntity> = try {
        transaction {
            val userDao = UsersEntity.findById(id.toInt()) ?: throw Exception("User with $id ID not found")

            userDao.userStatus = UserStatusMapper().toValue(UserStatus.SUSPENDED)

            RequestResult.Success(userDao.toDataEntity())
        }
    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }

    override suspend fun banUser(id: String): RequestResult<UserEntity> = try {
        transaction {
            val userDao = UsersEntity.findById(id.toInt()) ?: throw Exception("User with $id ID not found")

            userDao.userStatus = UserStatusMapper().toValue(UserStatus.BANNED)

            RequestResult.Success(userDao.toDataEntity())
        }
    } catch (e: Exception) {
        RequestResult.Error(exception = e)
    }
}