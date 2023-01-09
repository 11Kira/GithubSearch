package com.test.githubsearch.repo

import com.test.githubsearch.core.apiSafeCall
import com.test.githubsearch.core.dispatcherIO
import kotlinx.coroutines.withContext

/**
 * Repo class for searching the github repositories
 * @author Julius Villagracia
 */
class RepoRemoteSource(private val repositoryService: RepositoryApi) {
    suspend fun searchRepositories(query: String?, type: String?) = apiSafeCall {
        withContext(dispatcherIO) {
            repositoryService.searchRepositories(query, type)
        }
    }
}