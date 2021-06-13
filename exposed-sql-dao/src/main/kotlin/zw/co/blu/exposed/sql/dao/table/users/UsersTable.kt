package zw.co.blu.exposed.sql.dao.table.users

//import org.jetbrains.exposed.sql.Table
//import zw.co.blu.exposed.sql.dao.table.roles.RolesTable
//
//object UsersTable : Table() {
//    val id = integer("id").autoIncrement()
//    val username = varchar("username", 255)
//    val email = varchar("email", 255)
//    val userStatus = varchar("userStatus", 255)
//    val roleId = (integer("role_id") references RolesTable.id).nullable()
//
//    override val primaryKey = PrimaryKey(id, name = "PK_Users_ID")
//}
