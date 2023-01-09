package com.test.githubsearch.repo

import androidx.lifecycle.viewModelScope
import com.test.githubsearch.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

/**
 * ViewModel class for the repository related API calls
 * @author Julius Villagracia
 */
@HiltViewModel
class RepositoryViewModel @Inject constructor(
    private val repoUseCase: RepoUseCase
) : BaseViewModel() {

    private val mutableRepoState: MutableSharedFlow<RepoState> = MutableSharedFlow()
    val repoState = mutableRepoState.asSharedFlow()

    /**
     * Submits the search query to API
     * @param query The search query to be submitted
     * @param type The type of search
     */
    fun searchRepositories(query: String, type: String) {
        viewModelScope.launch(
            CoroutineExceptionHandler {_, error -> runBlocking { mutableRepoState.emit(RepoState.ShowError(error = error)) }}
        ) {
            mutableRepoState.emit(RepoState.ShowLoading)
            val searchResults = repoUseCase.searchRepositories(query, type)
            searchResults.let { data ->
                mutableRepoState.emit(RepoState.SetResults(data))
            }
        }
    }
}