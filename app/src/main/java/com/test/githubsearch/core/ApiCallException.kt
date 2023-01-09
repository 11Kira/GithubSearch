package com.test.githubsearch.core

import retrofit2.HttpException
import java.net.SocketException
import java.net.UnknownHostException

@Throws(ServiceException::class)
inline fun <reified T> apiSafeCall(call: () -> T) = try {
    call()
} catch (e: CancellationException) {
    throw CancellationException(
        ErrorResponse(
            message = e.message,
            exception = e.cause
        )
    )
} catch (e: Exception) {
    throw ServiceException(
        when (e) {
            is UnknownHostException -> {
                ErrorResponse(
                    message = "No internet connection!",
                    exception = e.cause
                )
            }
            is SocketException -> {
                ErrorResponse(
                    message = e.message,
                    exception = e.cause
                )
            }
            is CancellationException -> {
                ErrorResponse(
                    message = e.message,
                    exception = e.cause
                )
            }
            is HttpException -> {
                ErrorResponse(
                    message = e.message,
                    exception = e.cause
                )
            }
            else -> {
                ErrorResponse(
                    message = e.message,
                    exception = e.cause
                )
            }
        }
    )
}