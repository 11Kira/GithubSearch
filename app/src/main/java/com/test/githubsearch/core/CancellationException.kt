package com.test.githubsearch.core

open class CancellationException(
    val errorResponse: ErrorResponse
) : RuntimeException(errorResponse.message)