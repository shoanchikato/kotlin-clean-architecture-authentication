package zw.co.blu.domain.model.roles

sealed class RoleStatus {
    object ACTIVE: RoleStatus()
    object INACTIVE: RoleStatus()

    override fun toString(): String {
        return when(this) {
            is ACTIVE -> "ACTIVE"
            is INACTIVE -> "INACTIVE"
        }
    }

    val value: Int
    get(): Int {
        return when(this) {
            is ACTIVE -> 1
            is INACTIVE -> 2
        }
    }
}