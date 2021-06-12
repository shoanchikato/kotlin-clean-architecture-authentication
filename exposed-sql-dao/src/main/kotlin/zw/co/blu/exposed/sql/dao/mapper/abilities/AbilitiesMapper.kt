package zw.co.blu.exposed.sql.dao.mapper.abilities

import zw.co.blu.domain.model.abilities.Ability

class AbilitiesMapper() {
    fun fromValue(value: Int): Ability {
        return when (value) {
            1 -> Ability.CREATE
            2 -> Ability.READ
            3 -> Ability.EDIT
            4 -> Ability.DELETE
            5 -> Ability.ACTIVATE
            6 -> Ability.DEACTIVATE
            7 -> Ability.SUSPEND
            8 -> Ability.BAN
            else -> Ability.READ
        }
    }

    fun toValue(ability: Ability): Int {
        return when (ability) {
            is Ability.CREATE -> 1
            is Ability.READ -> 2
            is Ability.EDIT -> 3
            is Ability.DELETE -> 4
            is Ability.ACTIVATE -> 5
            is Ability.DEACTIVATE -> 6
            is Ability.SUSPEND -> 7
            is Ability.BAN -> 8
        }
    }
}