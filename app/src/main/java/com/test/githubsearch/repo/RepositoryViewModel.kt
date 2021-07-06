package com.test.githubsearch.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.githubsearch.core.BaseViewModel
import com.test.githubsearch.core.UIEvent
import org.koin.core.component.inject

class RepositoryViewModel : BaseViewModel() {

    private val repositoryResultsRepo: RepositoryResultsRepo by inject()

    private val _events = MutableLiveData<UIEvent>()
    val events: LiveData<UIEvent> = _events

}