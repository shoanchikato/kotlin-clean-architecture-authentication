package zw.co.blu.model

sealed class UserStatus {
    data class Active(val value: String = "ACTIVE")
    data class Inactive(val value: String = "INACTIVE")
    data class Pending(val value: String = "PENDING")
    data class Suspended(val value: String = "SUSPENDED")
    data class Banned(val value: String = "BANNED")
}