package zw.co.blu.exposed.sql.dao.repository

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import zw.co.blu.data.model.permissions.PermissionEntity
import zw.co.blu.data.model.roles.RoleDaoEntity
import zw.co.blu.data.model.roles.RoleEditDaoEntity
import zw.co.blu.data.model.roles.RoleEntity
import zw.co.blu.data.model.users.UserDaoEntity
import zw.co.blu.data.model.users.UserEntity
import zw.co.blu.domain.model.permissions.PermissionStatus
import zw.co.blu.domain.model.privileges.Privileges
import zw.co.blu.domain.model.roles.RoleStatus
import zw.co.blu.domain.model.users.UserStatus
import zw.co.blu.exposed.sql.dao.mapper.permissions.PermissionStatusMapper
import zw.co.blu.exposed.sql.dao.mapper.privileges.PrivilegesMapper
import zw.co.blu.exposed.sql.dao.mapper.roles.RoleStatusMapper
import zw.co.blu.exposed.sql.dao.table.permissions.PermissionsEntity
import zw.co.blu.exposed.sql.dao.table.permissions.PermissionsTable
import zw.co.blu.exposed.sql.dao.table.permissionsPrivileges.PermissionPrivilegesTable
import zw.co.blu.exposed.sql.dao.table.privileges.PrivilegesEntity
import zw.co.blu.exposed.sql.dao.table.privileges.PrivilegesTable
import zw.co.blu.exposed.sql.dao.table.rolePermissions.RolePermissionsTable
import zw.co.blu.exposed.sql.dao.table.roles.RolesEntity
import zw.co.blu.exposed.sql.dao.table.roles.RolesTable

class TestDependencies {
    companion object {
        fun initDatabaseConnection(): Database {
            return Database.connect(
                    url = "jdbc:h2:mem:regular;DB_CLOSE_DELAY=-1;",
                    driver = "org.h2.Driver",
                    user = "root",
                    password = ""
            )
        }

        // PERMISSIONS

        private val privileges = listOf(
                Privileges.ACTIVATE,
                Privileges.EDIT,
                Privileges.READ,
        )

        val permissionInput = PermissionEntity(
                id = "1",
                name = "BOOKS",
                permissionStatus = PermissionStatus.ACTIVE,
                privileges = privileges,
        )

        // ROLES

        val roleInput = RoleEntity(
                id = "1",
                name = "ADMIN",
                roleStatus = RoleStatus.ACTIVE,
                permissions = listOf(permissionInput)
        )

        val roleCreateInput = RoleDaoEntity(
                name = "ADMIN",
                permissionIds = listOf("1")
        )

        private val permission2 = PermissionEntity(
                id = "2",
                name = "VEHICLES",
                permissionStatus = PermissionStatus.ACTIVE,
                privileges = listOf(Privileges.READ, Privileges.CREATE, Privileges.EDIT)
        )
        private val permission3 = PermissionEntity(
                id = "3",
                name = "FILES",
                permissionStatus = PermissionStatus.ACTIVE,
                privileges = listOf(Privileges.READ)
        )
        val roleEditInput = RoleEditDaoEntity(
                id = "1",
                name = "MANAGER",
                roleStatus = RoleStatus.INACTIVE,
                permissionIds = listOf("2", "3")
        )

        val roleEditOutput = RoleEntity(
                id = "1",
                name = "MANAGER",
                roleStatus = RoleStatus.INACTIVE,
                permissions = listOf(permission2, permission3)
        )

        val roleOutput = RoleEntity(
                id = "2",
                name = "ADMIN",
                roleStatus = RoleStatus.ACTIVE,
                permissions = listOf(permissionInput)
        )

        private val inputPermissions = listOf(permission2, permission3, roleInput.permissions.first())

        // USERS
        val userInput = UserDaoEntity(
                username = "john_doe",
                email = "john@doe.com",
                roleId = "1",
        )

        val userOutput = UserEntity(
                id = "1",
                username = userInput.username,
                email = userInput.email,
                userStatus = UserStatus.ACTIVE,
                role = roleOutput
        )

        // LOADERS

        fun loadPermissions() {
            transaction {
                addLogger(StdOutSqlLogger)
                SchemaUtils.drop(PermissionsTable, PrivilegesTable, PermissionPrivilegesTable)
                SchemaUtils.create(PermissionsTable, PrivilegesTable, PermissionPrivilegesTable)
            }

            val permission = transaction {
                PermissionsEntity.new {
                    name = permissionInput.name
                    permissionStatus = PermissionStatusMapper().toValue(permissionInput.permissionStatus)
                }
            }

            val privileges = transaction {
                permissionInput.privileges.map { privilege ->
                    PrivilegesEntity.new {
                        value = PrivilegesMapper().toValue(privilege)
                        name = privilege.toString()
                    }
                }
            }

            transaction {
                permission.privileges = SizedCollection(privileges)
            }

        }

        fun loadRoles() {
            transaction {
                addLogger(StdOutSqlLogger)
                SchemaUtils.drop(PermissionsTable, PrivilegesTable, PermissionPrivilegesTable, RolesTable, RolePermissionsTable)
                SchemaUtils.create(PermissionsTable, PrivilegesTable, PermissionPrivilegesTable, RolesTable, RolePermissionsTable)
            }

            // val roleDao =
            val roleDao = transaction {
                RolesEntity.new {
                    name = roleInput.name
                    roleStatus = RoleStatusMapper().toValue(roleInput.roleStatus)
                }
            }

            // val permissions =
            val permissions = roleInput.permissions.map { permission ->

                val permissionDao = transaction {
                    PermissionsEntity.new {
                        name = permission.name
                        permissionStatus = PermissionStatusMapper().toValue(permission.permissionStatus)
                    }
                }

                val privileges = transaction {
                    permission.privileges.map { privilege ->
                        PrivilegesEntity.new {
                            name = privilege.toString()
                            value = PrivilegesMapper().toValue(privilege)
                        }
                    }
                }

                transaction {
                    permissionDao.privileges = SizedCollection(privileges)
                    permissionDao
                }
            }

            inputPermissions.map { permission ->

                val permissionDao = transaction {
                    PermissionsEntity.new {
                        name = permission.name
                        permissionStatus = PermissionStatusMapper().toValue(permission.permissionStatus)
                    }
                }

                val privileges = transaction {
                    permission.privileges.map { privilege ->
                        PrivilegesEntity.new {
                            name = privilege.toString()
                            value = PrivilegesMapper().toValue(privilege)
                        }
                    }
                }

                transaction {
                    permissionDao.privileges = SizedCollection(privileges)
                    permissionDao
                }
            }

            transaction {
                roleDao.permissions = SizedCollection(permissions)
            }

            fun loadUsers() {
                loadRoles()

                transaction {

                }
            }

        }
    }
}