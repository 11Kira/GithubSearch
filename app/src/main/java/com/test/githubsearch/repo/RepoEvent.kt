package com.test.githubsearch.repo

import com.test.githubsearch.core.UIEvent

/**
 * Events returned by RepositoryViewModel
 * @author Julius Villagracia
 */
sealed class RepoEvent : UIEvent {
    data class OnStartLoading(val success: Boolean) : RepoEvent()
    data class OnFailedFetching(val error: String) : RepoEvent()
    data class OnFinishedLoading(val repositories: List<Repository>) : RepoEvent()
    object OnNoAvailable: RepoEvent()
}