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
}