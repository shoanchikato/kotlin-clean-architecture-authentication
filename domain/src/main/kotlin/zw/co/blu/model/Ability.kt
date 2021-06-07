package zw.co.blu.model

sealed class Ability {
    data class Create(val value: String = "CREATE") : Ability()
    data class Read(val value: String = "READ") : Ability()
    data class Edit(val value: String = "EDIT") : Ability()
    data class Delete(val value: String = "DELETE") : Ability()
    data class Activate(val value: String = "ACTIVATE") : Ability()
    data class Deactivate(val value: String = "DEACTIVATE") : Ability()
    data class Suspend(val value: String = "SUSPEND") : Ability()
    data class Ban(val value: String = "BAN") : Ability()
}