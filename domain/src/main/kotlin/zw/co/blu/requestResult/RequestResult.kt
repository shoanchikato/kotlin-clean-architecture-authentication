package zw.co.blu.requestResult

import kotlin.Exception

sealed class RequestResult<T> {
    data class Success<T>(val value: T): RequestResult<T>()
    data class Error<T>(val exception: Exception): RequestResult<T>()
}

fun <T> RequestResult<T>.isSuccess(): Boolean {
    return when(this) {
        is RequestResult.Success -> true
        is RequestResult.Error -> false
    }
}