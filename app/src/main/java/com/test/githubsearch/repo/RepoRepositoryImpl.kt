package com.test.githubsearch.repo

import com.test.githubsearch.core.mapSearchResponseToDomain
import com.test.githubsearch.model.Repository
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(
    private val repoRemoteSource: RepoRemoteSource
) {
    suspend fun searchRepositories(query: String?, type: String?): List<Repository> {
        return repoRemoteSource.searchRepositories(query = query, type = type).mapSearchResponseToDomain()
    }
}