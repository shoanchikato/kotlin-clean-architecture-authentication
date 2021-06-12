package zw.co.blu.exposed.sql.dao.mapper.tokens

import zw.co.blu.data.model.tokens.TokensEntity
import zw.co.blu.exposed.sql.dao.mapper.Mapper
import zw.co.blu.exposed.sql.dao.model.tokens.TokensModel

class TokensEntityMapper (): Mapper<TokensEntity, TokensModel> {
    override fun mapFromModel(type: TokensEntity): TokensModel {
        return TokensModel(
                access = type.access,
                refresh = type.refresh,
        )
    }

    override fun mapToModel(type: TokensModel): TokensEntity {
        return TokensEntity(
                access = type.access,
                refresh = type.refresh,
        )
    }
}