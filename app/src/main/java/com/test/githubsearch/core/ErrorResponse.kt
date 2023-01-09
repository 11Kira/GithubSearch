package com.test.githubsearch.core

import kotlinx.serialization.Contextual

@kotlinx.serialization.Serializable
data class ErrorResponse(
    val message: String? = null,
    val exception: @Contextual Throwable? = null,
    val errors: Error? = null
)