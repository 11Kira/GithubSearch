package com.test.githubsearch.repo

class RepositoryResultsRepo(private val repositoryApi: RepositoryApi) {

    suspend fun searchRepositories(
        query: String?,
        type: String?
    ) = repositoryApi.searchRepositories(query, type).body()
}