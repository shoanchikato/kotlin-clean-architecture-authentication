package zw.co.blu.exposed.sql.dao.table.abilities

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import zw.co.blu.exposed.sql.dao.mapper.abilities.AbilitiesMapper
import zw.co.blu.exposed.sql.dao.table.permissions.PermissionsTable

object AbilitiesTable : IntIdTable() {
    val value = integer("value")
    val name = varchar("name", 100)

    override val primaryKey = PrimaryKey(PermissionsTable.id, name = "PK_Abilities_ID")
}

class AbilitiesEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AbilitiesEntity>(AbilitiesTable)

    var value by AbilitiesTable.value
    var name by AbilitiesTable.name

    fun toModel() = AbilitiesMapper().fromValue(this.value)
}