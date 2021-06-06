package zw.co.blu.requestResult

sealed class RequestResult {
    data class Success<T>(val value: T) : RequestResult()
    data class Error<T>(val value: T) : RequestResult()
}