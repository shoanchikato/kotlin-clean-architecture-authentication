package zw.co.blu.model.abilities

sealed class Ability {
    object CREATE: Ability()
    object READ: Ability()
    object EDIT: Ability()
    object DELETE: Ability()
    object ACTIVATE: Ability()
    object DEACTIVATE: Ability()
    object SUSPEND: Ability()
    object BAN: Ability()

    override fun toString(): String {
        return when(this) {
            is CREATE -> "CREATE"
            is READ -> "READ"
            is EDIT -> "EDIT"
            is DELETE -> "DELETE"
            is ACTIVATE -> "ACTIVATE"
            is DEACTIVATE -> "DEACTIVATE"
            is SUSPEND -> "SUSPEND"
            is BAN -> "BAN"
        }
    }
}