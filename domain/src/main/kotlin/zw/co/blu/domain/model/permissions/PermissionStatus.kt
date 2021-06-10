package zw.co.blu.domain.model.permissions

sealed class PermissionStatus {
    object ACTIVE: PermissionStatus()
    object INACTIVE: PermissionStatus()

    override fun toString(): String {
        return when(this) {
            is ACTIVE -> "ACTIVE"
            is INACTIVE -> "INACTIVE"
        }
    }
}