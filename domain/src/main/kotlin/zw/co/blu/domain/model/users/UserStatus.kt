package zw.co.blu.domain.model.users

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

    val value: Int
    get(): Int{
        return when(this) {
            is ACTIVE -> 1
            is INACTIVE -> 2
            is PENDING -> 3
            is SUSPENDED -> 4
            is BANNED -> 5
        }
    }
}