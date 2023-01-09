package com.test.githubsearch.repo

import com.test.githubsearch.core.mapSearchResponseToDomain

class RepoRepositoryImpl (private val repoRemoteSource: RepoRemoteSource) {
    suspend fun searchRepositories(query: String?, type: String?): List<Repository> {
        return repoRemoteSource.searchRepositories(query = query, type = type).mapSearchResponseToDomain()
    }
}