package com.test.githubsearch.repo

import com.test.githubsearch.core.apiSafeCall
import com.test.githubsearch.core.dispatcherIO
import com.test.githubsearch.core.network.RepositoryApi
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Repo class for searching the github repositories
 * @author Julius Villagracia
 */
class RepoRemoteSource @Inject constructor(
    private val repositoryService: RepositoryApi
) {
    suspend fun searchRepositories(query: String?, type: String?) = apiSafeCall {
        withContext(dispatcherIO) {
            repositoryService.searchRepositories(query, type)
        }
    }
}