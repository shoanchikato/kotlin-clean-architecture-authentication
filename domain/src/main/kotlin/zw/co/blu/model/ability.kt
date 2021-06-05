package zw.co.blu.model

sealed class Ability {
    data class Read(val value: String = "READ"): Ability()
    data class Writ(val value: String = "WRITE"): Ability()
}