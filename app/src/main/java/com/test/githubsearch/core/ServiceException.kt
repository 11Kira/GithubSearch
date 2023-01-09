package com.test.githubsearch.core

open class ServiceException(
    val errorResponse: ErrorResponse
) : RuntimeException(errorResponse.message)