package zw.co.blu.exposed.sql.dao.mapper.privileges

import zw.co.blu.domain.model.privileges.Privileges

class PrivilegesMapper() {
    fun fromValue(value: Int): Privileges {
        return when (value) {
            1 -> Privileges.CREATE
            2 -> Privileges.READ
            3 -> Privileges.EDIT
            4 -> Privileges.DELETE
            5 -> Privileges.ACTIVATE
            6 -> Privileges.DEACTIVATE
            7 -> Privileges.SUSPEND
            8 -> Privileges.BAN
            else -> Privileges.READ
        }
    }

    fun toValue(privileges: Privileges): Int {
        return when (privileges) {
            is Privileges.CREATE -> 1
            is Privileges.READ -> 2
            is Privileges.EDIT -> 3
            is Privileges.DELETE -> 4
            is Privileges.ACTIVATE -> 5
            is Privileges.DEACTIVATE -> 6
            is Privileges.SUSPEND -> 7
            is Privileges.BAN -> 8
        }
    }
}