package zw.co.blu.model

sealed class RoleStatus {
    data class Active(val value: String = "ACTIVE")
    data class Inactive(val value: String = "INACTIVE")
}