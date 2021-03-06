package zw.co.blu.data.mapper.credentials

import zw.co.blu.data.mapper.Mapper
import zw.co.blu.data.model.credentials.CredentialsEntity
import zw.co.blu.domain.model.credentials.Credentials

class CredentialMapper (): Mapper<CredentialsEntity, Credentials> {
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