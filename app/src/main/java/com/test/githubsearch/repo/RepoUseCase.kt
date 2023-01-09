package com.test.githubsearch.repo

class RepoUseCase (private val repoRepositoryImpl: RepoRepositoryImpl){
    suspend fun searchRepositories(query: String?, type: String?): List<Repository> {
        return repoRepositoryImpl.searchRepositories(query, type)
    }
}