package zw.co.blu.exposed.sql.dao.tables.abilities

import org.jetbrains.exposed.sql.Table

object AbilitiesTable : Table() {
    val value = integer("value")
    val name = varchar("name", 100)
}