package zw.co.blu.exposed.sql.dao.tables.abilities

import org.jetbrains.exposed.sql.ResultRow
import zw.co.blu.domain.model.abilities.Ability
import zw.co.blu.exposed.sql.dao.mapper.abilities.AbilitiesMapper
import zw.co.blu.exposed.sql.dao.tables.permissionsAbilities.PermissionAbilitiesTable

fun ResultRow.toAbility(): Ability {
    return AbilitiesMapper().fromValue(this[PermissionAbilitiesTable.abilities_id])
}
