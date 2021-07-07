package com.test.githubsearch.repo

/**
 * Repo class for searching the github repositories
 * @author Julius Villagracia
 */
class RepositoryResultsRepo(private val repositoryApi: RepositoryApi) {

    suspend fun searchRepositories(
        query: String?,
        type: String?
    ) = repositoryApi.searchRepositories(query, type).body()
}