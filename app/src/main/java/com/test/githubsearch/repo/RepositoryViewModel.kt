package com.test.githubsearch.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.test.githubsearch.core.BaseViewModel
import com.test.githubsearch.core.UIEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.core.component.inject

/**
 * ViewModel class for the repository related API calls
 * @author Julius Villagracia
 */
class RepositoryViewModel : BaseViewModel() {

    private val repositoryResultsRepo: RepoRemoteSource by inject()
    private val repoUseCase: RepoUseCase by inject()

    private val _events = MutableLiveData<UIEvent>()
    val events: LiveData<UIEvent> = _events


    private val mutableRepoState: MutableSharedFlow<RepoState> = MutableSharedFlow()
    val repoState = mutableRepoState.asSharedFlow()

    /**
     * Submits the search query to API
     * @param query The search query to be submitted
     * @param type The type of search
     */
    fun searchRepositories(query: String, type: String) {
        //_events.value = RepoEvent.OnStartLoading(true)
        viewModelScope.launch(
            CoroutineExceptionHandler {_, error -> runBlocking { mutableRepoState.emit(RepoState.ShowError(error = error)) }}
        ) {
            mutableRepoState.emit(RepoState.ShowLoading)
            val searchResults = repoUseCase.searchRepositories(query, type)
            searchResults.let { data ->
                mutableRepoState.emit(RepoState.SetResults(data))
            }
            Log.e("testresults", searchResults.toString())
            /*val result = kotlin.runCatching { repositoryResultsRepo.searchRepositories(query, type) }
            withContext(Dispatchers.Main) {
                result.onSuccess { response ->
                    response?.items?.let { repoList ->
                        if (repoList.isEmpty()) {
                            _events.value = RepoEvent.OnNoAvailable
                        } else {
                            _events.value = RepoEvent.OnFinishedLoading(repoList)
                        }
                    }
                }.onFailure { error ->
                    _events.value = RepoEvent.OnFailedFetching(error.localizedMessage)
                }
            }*/
        }
    }
}