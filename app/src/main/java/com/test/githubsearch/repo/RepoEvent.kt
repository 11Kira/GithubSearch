package com.test.githubsearch.repo

import com.test.githubsearch.core.UIEvent

sealed class RepoEvent : UIEvent {
    data class OnStartLoading(val success: Boolean) : RepoEvent()
    data class OnFailedFetching(val error: String) : RepoEvent()
    data class OnFinishedLoading(val beers: List<Repository>) : RepoEvent()
    object OnNoAvailable: RepoEvent()
}