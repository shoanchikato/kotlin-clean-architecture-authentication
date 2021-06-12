package zw.co.blu.exposed.sql.dao.model.credentials

/**
 * @property username eg "john_doe"
 * @property password eg "eA%J23^$SAD"
 *
 * must be equal or greater than 8 characters
 * must be alphanumeric
 * must contain at least two special characters
 */
data class CredentialsModel(val username: String, val password: String)