package zw.co.blu.mapper.tokens

import Mapper
import zw.co.blu.model.tokens.Tokens
import zw.co.blu.model.tokens.TokensEntity

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