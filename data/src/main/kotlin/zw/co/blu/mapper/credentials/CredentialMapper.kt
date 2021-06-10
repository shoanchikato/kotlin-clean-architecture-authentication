package zw.co.blu.mapper.credentials

import Mapper
import zw.co.blu.model.credentials.Credentials
import zw.co.blu.model.credentials.CredentialsEntity

class CredentialsMapper (): Mapper<CredentialsEntity, Credentials> {
    override fun mapFromEntity(type: CredentialsEntity): Credentials {
        return Credentials(
                username = type.username,
                password = type.password,
        )
    }

    override fun mapToEntity(type: Credentials): CredentialsEntity {
        return CredentialsEntity(
                username = type.username,
                password = type.password,
        )
    }
}