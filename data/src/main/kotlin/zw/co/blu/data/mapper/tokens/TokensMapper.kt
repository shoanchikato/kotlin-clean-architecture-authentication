package zw.co.blu.data.mapper.tokens

import zw.co.blu.data.mapper.Mapper
import zw.co.blu.data.model.tokens.TokensEntity
import zw.co.blu.domain.model.tokens.Tokens

class TokensMapper (): Mapper<TokensEntity, Tokens> {
    override fun mapFromEntity(type: TokensEntity): Tokens {
        return Tokens(
                access = type.access,
                refresh = type.refresh,
        )
    }

    override fun mapToEntity(type: Tokens): TokensEntity {
        return TokensEntity(
                access = type.access,
                refresh = type.refresh,
        )
    }
}