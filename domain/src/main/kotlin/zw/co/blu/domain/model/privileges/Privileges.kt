package zw.co.blu.domain.model.privileges

sealed class Privileges {
    object CREATE: Privileges()
    object READ: Privileges()
    object EDIT: Privileges()
    object DELETE: Privileges()
    object ACTIVATE: Privileges()
    object DEACTIVATE: Privileges()
    object SUSPEND: Privileges()
    object BAN: Privileges()

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