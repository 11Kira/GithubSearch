package com.test.githubsearch.repo

import com.test.githubsearch.model.Repository
import javax.inject.Inject

class RepoUseCase @Inject constructor(
    private val repoRepositoryImpl: RepoRepositoryImpl
){
    suspend fun searchRepositories(query: String?, type: String?): List<Repository> {
        return repoRepositoryImpl.searchRepositories(query, type)
    }
}