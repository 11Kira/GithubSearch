package com.test.githubsearch.repo

sealed class RepoState {
    object ShowLoading : RepoState()
    data class ShowError(val error: Any): RepoState()
    data class SetResults(val repoList: List<Repository>) : RepoState()
}