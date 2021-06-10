package zw.co.blu.model.users

sealed class UserStatus {
    object ACTIVE: UserStatus()
    object INACTIVE: UserStatus()
    object PENDING: UserStatus()
    object SUSPENDED: UserStatus()
    object BANNED: UserStatus()

    override fun toString(): String {
        return when(this) {
            is ACTIVE -> "ACTIVE"
            is INACTIVE -> "INACTIVE"
            is PENDING -> "PENDING"
            is SUSPENDED -> "SUSPENDED"
            is BANNED -> "BANNED"
        }
    }
}