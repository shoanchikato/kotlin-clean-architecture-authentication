package zw.co.blu.model

/**
 * @property name eg. "BOOKS"
 * @property abilities eg. ["READ", "WRITE"]
 */
data class Permission(val name: String, val abilities: List<Ability>)
