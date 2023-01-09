package com.test.githubsearch.core

import com.test.githubsearch.core.response.ApiResponse
import com.test.githubsearch.repo.Repository
import retrofit2.Response

fun Response<ApiResponse<List<Repository>>>.mapSearchResponseToDomain(): List<Repository> {
    return this.body()?.items?.map { repository ->
        Repository(
            id = repository.id,
            nodeId = repository.nodeId,
            name = repository.name,
            fullName = repository.fullName,
            private = repository.private,
            owner= repository.owner,
            htmlUrl = repository.htmlUrl,
            description = repository.description,
            language = repository.language,
            stargazersCount = repository.stargazersCount,
        )
    } ?: emptyList()
}