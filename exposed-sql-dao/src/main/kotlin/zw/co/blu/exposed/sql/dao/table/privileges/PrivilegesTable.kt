package zw.co.blu.exposed.sql.dao.table.privileges

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import zw.co.blu.exposed.sql.dao.mapper.privileges.PrivilegesMapper
import zw.co.blu.exposed.sql.dao.table.permissions.PermissionsTable

object PrivilegesTable : IntIdTable() {
    val value = integer("value")
    val name = varchar("name", 100)

    override val primaryKey = PrimaryKey(PermissionsTable.id, name = "PK_Privileges_ID")
}

class PrivilegesEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PrivilegesEntity>(PrivilegesTable)

    var value by PrivilegesTable.value
    var name by PrivilegesTable.name

    fun fromValue() = PrivilegesMapper().fromValue(this.value)
}