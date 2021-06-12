package zw.co.blu.exposed.sql.dao.mapper.credentials

import zw.co.blu.data.model.credentials.CredentialsEntity
import zw.co.blu.exposed.sql.dao.mapper.Mapper
import zw.co.blu.exposed.sql.dao.model.credentials.CredentialsModel

class CredentialsEntityMapper (): Mapper<CredentialsEntity, CredentialsModel> {
    override fun mapFromModel(type: CredentialsEntity): CredentialsModel {
        return CredentialsModel(
                username = type.username,
                password = type.password,
        )
    }

    override fun mapToModel(type: CredentialsModel): CredentialsEntity {
        return CredentialsEntity(
                username = type.username,
                password = type.password,
        )
    }
}