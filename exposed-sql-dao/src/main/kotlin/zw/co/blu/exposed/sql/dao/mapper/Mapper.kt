package zw.co.blu.exposed.sql.dao.mapper

interface Mapper<M, E> {

    fun mapFromModel(type: M): E

    fun mapToModel(type: E): M
}